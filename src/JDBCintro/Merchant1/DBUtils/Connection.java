package JDBCintro.Merchant1.DBUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connection {
    public static java.sql.Connection getConnection() throws SQLException, IOException {
        java.sql.Connection conn;
        Properties properties = new Properties ( );
        try (BufferedReader in = Files.newBufferedReader (Paths.get ("C:\\Go2IT\\Projects\\src\\app.properties"), StandardCharsets.UTF_8)) {
            properties.load (in);
        }
        String dbUrl = properties.getProperty ("dbUrlAddress");
        String userName = properties.getProperty ("userName");
        String pass = properties.getProperty ("password");
        conn = DriverManager.getConnection (dbUrl, userName, pass);
        return conn;
    }

}

