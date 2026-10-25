package Lab8;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static final Logger logger = Logger.getLogger(DBConnection.class.getName());
    private static Connection connection = null;

    static {
        try {
            System.out.println("DB Connection Start");
            Properties prop = new Properties();
            InputStream input = new FileInputStream("D:\\Storage\\Projects\\MSIS\\CAJ\\MSISME-CAJ\\Lab\\CAJ_Assignments\\src\\Lab8\\db.properties");prop.load(input);
            String driver = prop.getProperty("db.driver");
            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            logger.info("database connection established successfully");
            System.out.println("DB Connection Successful");
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, "Database connection failed", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
