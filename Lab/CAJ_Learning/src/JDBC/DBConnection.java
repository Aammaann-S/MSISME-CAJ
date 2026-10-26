package JDBC;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger logger =
            Logger.getLogger(DBConnection.class.getName());

    private static Connection connection = null;

    static {
        try {
            Properties prop = new Properties();

            try (InputStream input = new FileInputStream(
                    "D:\\Storage\\Projects\\MSIS\\CAJ\\MSISME-CAJ\\Lab\\CAJ_Learning\\src\\JDBC\\db.properties")) {
                prop.load(input);
            }

            Class.forName(prop.getProperty("db.driver"));

            connection = DriverManager.getConnection(
                    prop.getProperty("db.url"),
                    prop.getProperty("db.username"),
                    prop.getProperty("db.password", "")
            );

            logger.info("Database connected successfully.");

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Database connection failed.", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
