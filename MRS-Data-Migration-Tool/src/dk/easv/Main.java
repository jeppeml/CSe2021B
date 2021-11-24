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

        List<String> movies = Files.readAllLines(Path.of("data/movie_titles.txt"));
        System.out.println("Movies: " + movies.size());
/*
        try (Connection con = ds.getConnection()) {
            String sql = "INSERT INTO Movies (Id, Title, Year) VALUES (2, 'million', 2013)";
            PreparedStatement st = con.prepareStatement(sql);
            int affected = st.executeUpdate();
            System.out.println("Affected rows: " + affected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
    }
}
