package dk.easv;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // Configuring the connection
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setDatabaseName("testing_no_sus");
        ds.setUser("CSe21B_39");
        ds.setPassword("CSe21B_39");
        ds.setPortNumber(1433);
        ds.setServerName("10.176.111.31");

        // Deletes the tables and recreates them
        removeTablesAndRecreate(ds);

        migrateMovies(ds);
        migrateUsers(ds);

        long start = System.currentTimeMillis();
        System.out.println("Starting migration of ratings...");
        migrateRatings(ds);
        System.out.println("Time taken: " + ((System.currentTimeMillis()-start)/1000d) + "s");

    }

    private static void removeTablesAndRecreate(SQLServerDataSource ds){
        try (Connection con = ds.getConnection()) {
            String sql =
                    "DROP TABLE Ratings;\n" +
                    "DROP TABLE Movies;\n" +
                    "DROP TABLE Users;\n" +
                    "CREATE TABLE Movies(\n" +
                    "    Id int PRIMARY KEY,\n" +
                    "    Title VARCHAR(1000),\n" +
                    "    Year int\n" +
                    ");\n" +
                    "CREATE TABLE Ratings(\n" +
                    "    MovieId int,\n" +
                    "    UserId int,\n" +
                    "    Rating int\n" +
                    ");\n" +
                    "CREATE TABLE Users(\n" +
                    "    Id int PRIMARY KEY,\n" +
                    "    [Name] VARCHAR(1000)\n" +
                    ");\n" +
                    "ALTER TABLE Ratings\n" +
                    "ADD FOREIGN KEY (MovieId) REFERENCES Movies(id);\n" +
                    "\n" +
                    "ALTER TABLE Ratings\n" +
                    "ADD FOREIGN KEY (UserId) REFERENCES Users(id);";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void migrateRatings(SQLServerDataSource ds){
        List<String> movies = null;
        try {
            movies = Files.readAllLines(Path.of("data/ratings.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }//movie user rating
        try (Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Ratings (MovieId, UserId, Rating) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            con.setAutoCommit(false); // should improve performance, but I am sceptical
            System.out.println("Starting to add batch");
            int rowsBetweenCommits = 200_000;
            int count =0;
            int sumCount=0;
            for (String s : movies) {
                String[] values = s.split(",");
                int movieId = Integer.parseInt(values[0]);
                int userId = Integer.parseInt(values[1]);
                int rating = Integer.parseInt(values[2]);

                st.setInt(1, movieId);
                st.setInt(2, userId);
                st.setInt(3, rating);
                st.addBatch();
                count++;
                if(count == rowsBetweenCommits){
                    long startCommit = System.currentTimeMillis();
                    System.out.println("Executing next batch of : " + rowsBetweenCommits + " rows (so far before this: " + sumCount+ "/"+movies.size()+")");
                    sumCount+=rowsBetweenCommits;
                    st.executeBatch();
                    System.out.println("Finished executing batch. Committing");
                    con.commit(); // needed because autocommit = false
                    System.out.println("Time taken: " + ((System.currentTimeMillis()-startCommit)/1000d) + "s");
                    System.out.println("Continuing...");
                    count = 0;

                }
            }
            System.out.println("Executing last batch");
            st.executeBatch();
            System.out.println("Finished executing last batch. Committing");
            con.commit(); // needed because autocommit = false
            con.setAutoCommit(true);
            System.out.println("All done...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void migrateUsers(SQLServerDataSource ds){
        List<String> movies = null;
        try {
            movies = Files.readAllLines(Path.of("data/users.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Users (Id, [Name]) VALUES (?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            for (String s : movies) {
                String[] values = s.split(",");
                int id = Integer.parseInt(values[0]);
                String name = values[1];

                st.setInt(1, id);
                st.setString(2, name);
                st.addBatch();
            }
            st.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void migrateMovies(SQLServerDataSource ds){
        List<String> movies = null;
        try {
            movies = Files.readAllLines(Path.of("data/movie_titles.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Movies (Id, Title, Year) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            for (String s : movies) {
                String[] values = s.split(",");
                try {
                    int id = Integer.parseInt(values[0]);
                    String title = values[2];
                    int year = Integer.parseInt(values[1]);
                    //System.out.println("input: " + s);

                    st.setInt(1, id);
                    st.setString(2, title);
                    st.setInt(3, year);
                    st.addBatch();
                }
                catch(NumberFormatException nfe){

                }

            }
            st.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
