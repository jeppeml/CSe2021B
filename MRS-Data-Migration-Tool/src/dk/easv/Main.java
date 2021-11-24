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
        ds.setDatabaseName("testing");
        ds.setUser("CSe21B_39");
        ds.setPassword("CSe21B_39");
        ds.setPortNumber(1433);
        ds.setServerName("10.176.111.31");

        //migrateMovies(ds);
        //migrateUsers(ds);
        long start = System.currentTimeMillis();
        System.out.println("Starting...");
        migrateRatings(ds);
        System.out.println("Time taken: " + (System.currentTimeMillis()-start));
    }
    private static void migrateRatings(SQLServerDataSource ds){
        List<String> movies = null;
        try {
            movies = Files.readAllLines(Path.of("data/ratings.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }//movie user rating
        try (Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Users (MovieId, UserId, Rating) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            for (String s : movies) {
                String[] values = s.split(",");
                int movieId = Integer.parseInt(values[0]);
                int userId = Integer.parseInt(values[1]);
                int rating = Integer.parseInt(values[2]);

                st.setInt(1, movieId);
                st.setInt(2, userId);
                st.setInt(3, rating);
                st.addBatch();
            }
            st.executeBatch();

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
                int id = Integer.parseInt(values[0]);
                String title = values[2];
                int year = Integer.parseInt(values[1]);
                //System.out.println("input: " + s);

                st.setInt(1, id);
                st.setString(2, title);
                st.setInt(3, year);
                st.addBatch();
            }
            st.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
