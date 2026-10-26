package Lab8;

import java.sql.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EmployeeDAO {
    private static final Logger logger = Logger.getLogger(EmployeeDAO.class.getName());
    private Connection conn = null;
    private PreparedStatement ps = null;

    public void prepareDAO() {
        try {
            System.out.println("DB Connection Call");
            conn = DBConnection.getConnection();
            if (conn == null) {
                throw new SQLException("Connection is null. Check DBConnection logs.");
            }
            String query = "INSERT INTO employee (id, name, salary) VALUES (?,?,?)";
            ps = conn.prepareStatement(query);
            FileHandler fh = new FileHandler("employeeApp.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            System.out.println("DB Connection Complete");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Database connection failed", e);
            System.out.println("Database Connection Failed");
        }
    }

    public void insertEmployee(int id, String name, float salary) {
        try {
            if (ps == null) {
                logger.severe("DAO is not initialized.");
                return;
            }
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setFloat(3, salary);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                logger.info(rows + " Employee(s) Inserted Successfully");
                System.out.println(rows + " Employee(s) Inserted Successfully");
            } else {
                logger.warning("No employee was inserted.");
                System.out.println("No employee was inserted.");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error Inserting Employee", e);
        }
    }

    public void fetchAllEmployee() {
        if (conn == null) {
            logger.severe("Database connection is not available.");
            return;
        }
        String query = "SELECT * FROM employee";
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                logger.info("ID" + rs.getInt("id") +
                        ", Name:" + rs.getString("name") +
                        ", Salary:" + rs.getDouble("salary"));
                System.out.println("ID" + rs.getInt("id") + ", Name:" + rs.getString("name") + ", Salary:"
                        + rs.getDouble("salary"));
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching employees", e);
        }
    }

    public void deleteEmployee(int id) {
        String query = "Delete FROM employee where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                logger.info(rows + "Employee Deleted Successfully");
                System.out.println(rows + "Employee Deleted Successfully");
            } else {
                System.out.println(rows + "No Employee(s) found");
                logger.info(rows + "No Employee(s) found");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error Deleted Employee", e);
        }
    }

    public void updateEmployee(int id, String name, float salary) {
        String query = "Update employee SET name = ?, salary = ? WHERE id = ? ";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setFloat(2, salary);
            stmt.setString(1, name);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                logger.info(rows + " Employee(s) Updated Successfully");
                System.out.println(rows + " Employee(s) Updated Successfully");
            } else {
                logger.info("No employee found with ID: " + id);
                System.out.println("No employee found with ID: " + id);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error Updating Employee", e);
        }
    }

}
