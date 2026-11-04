package Submissions.Assignment2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    static {
        try {
            Properties prop = new Properties();

            try (InputStream input = new FileInputStream(
                    "D:\\Storage\\Projects\\MSIS\\CAJ\\MSISME-CAJ\\Lab\\CAJ_Assignments\\src\\Submissions\\Assignment2\\db.properties")) {
                prop.load(input);
            }

            Class.forName(prop.getProperty("db.driver"));

            connection = DriverManager.getConnection(
                    prop.getProperty("db.url"),
                    prop.getProperty("db.username"),
                    prop.getProperty("db.password", ""));

            System.out.println("Database Connection Successful!");

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
    }
}
