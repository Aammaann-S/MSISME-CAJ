package JDBC;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationDAO {
    private static final Logger logger =
            Logger.getLogger(RegistrationDAO.class.getName());

    private Connection conn;

    public RegistrationDAO() {
        conn = DBConnection.getConnection();
    }

    // Record successful activities
    private void logActivity(String activity, String details)
            throws SQLException {
        String query =
                "INSERT INTO Activity_Log (Activity, Details) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, activity);
            ps.setString(2, details);
            ps.executeUpdate();
        }
    }

    // ADD OR UPDATE STUDENT IN THE SAME METHOD
    public void saveStudent(int id, String name,
                            String email, String phone) {
        if (conn == null) {
            logger.severe("Database connection unavailable.");
            return;
        }

        String check = "SELECT Student_ID FROM Student WHERE Student_ID = ?";
        String insert =
                "INSERT INTO Student VALUES (?, ?, ?, ?)";
        String update =
                "UPDATE Student SET Student_Name = ?, Email = ?, Phone = ? " +
                        "WHERE Student_ID = ?";

        try {
            boolean exists;

            try (PreparedStatement ps = conn.prepareStatement(check)) {
                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    exists = rs.next();
                }
            }

            int rows;

            if (exists) {
                try (PreparedStatement ps = conn.prepareStatement(update)) {
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3, phone);
                    ps.setInt(4, id);
                    rows = ps.executeUpdate();
                }

                if (rows > 0) {
                    logActivity("UPDATE_STUDENT", "Student ID: " + id);
                    System.out.println("Student updated successfully.");
                }
            } else {
                try (PreparedStatement ps = conn.prepareStatement(insert)) {
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, email);
                    ps.setString(4, phone);
                    rows = ps.executeUpdate();
                }

                if (rows > 0) {
                    logActivity("ADD_STUDENT", "Student ID: " + id);
                    System.out.println("Student added successfully.");
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Saving student failed.", e);
        }
    }

    // ADD COURSE
    public void addCourse(int id, String name, int credits, int capacity) {
        if (conn == null) {
            logger.severe("Database connection unavailable.");
            return;
        }

        if (credits < 1 || credits > 6 || capacity <= 0) {
            System.out.println("Invalid credits or capacity.");
            return;
        }

        String query =
                "INSERT INTO Course VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, credits);
            ps.setInt(4, capacity);
            ps.setInt(5, capacity);

            ps.executeUpdate();

            logActivity("ADD_COURSE", "Course ID: " + id);
            System.out.println("Course added successfully.");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Adding course failed.", e);
        }
    }

    // REGISTER STUDENT FOR COURSE
    public void registerStudent(int registrationId,
                                int studentId, int courseId) {
        if (conn == null) {
            logger.severe("Database connection unavailable.");
            return;
        }

        String checkStudent =
                "SELECT Student_ID FROM Student WHERE Student_ID = ?";
        String checkCourse =
                "SELECT Available_Seats FROM Course WHERE Course_ID = ? FOR UPDATE";
        String insert =
                "INSERT INTO Registration " +
                        "(Registration_ID, Student_ID, Course_ID, Registration_Date, Status) " +
                        "VALUES (?, ?, ?, CURRENT_DATE, 'Active')";
        String updateSeats =
                "UPDATE Course SET Available_Seats = Available_Seats - 1 " +
                        "WHERE Course_ID = ? AND Available_Seats > 0";

        try {
            conn.setAutoCommit(false);

            try {
                // Check student exists
                try (PreparedStatement ps = conn.prepareStatement(checkStudent)) {
                    ps.setInt(1, studentId);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) {
                            throw new SQLException("Student does not exist.");
                        }
                    }
                }

                // Check course exists and has available seats
                try (PreparedStatement ps = conn.prepareStatement(checkCourse)) {
                    ps.setInt(1, courseId);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) {
                            throw new SQLException("Course does not exist.");
                        }

                        if (rs.getInt("Available_Seats") <= 0) {
                            throw new SQLException("Course is full.");
                        }
                    }
                }

                // Insert registration (FK and UNIQUE constraints apply)
                try (PreparedStatement ps = conn.prepareStatement(insert)) {
                    ps.setInt(1, registrationId);
                    ps.setInt(2, studentId);
                    ps.setInt(3, courseId);
                    ps.executeUpdate();
                }

                // Decrease available seats
                try (PreparedStatement ps = conn.prepareStatement(updateSeats)) {
                    ps.setInt(1, courseId);

                    if (ps.executeUpdate() != 1) {
                        throw new SQLException("Could not reserve a seat.");
                    }
                }

                logActivity("REGISTER_STUDENT",
                        "Registration: " + registrationId);

                conn.commit();
                System.out.println("Registration successful.");

            } catch (Exception e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Registration failed.", e);
        }
    }

    // CANCEL REGISTRATION AND RESTORE SEAT
    public void cancelRegistration(int registrationId) {
        if (conn == null) {
            logger.severe("Database connection unavailable.");
            return;
        }

        String find =
                "SELECT Course_ID FROM Registration " +
                        "WHERE Registration_ID = ? AND Status = 'Active' FOR UPDATE";
        String cancel =
                "UPDATE Registration SET Status = 'Cancelled' " +
                        "WHERE Registration_ID = ? AND Status = 'Active'";
        String restore =
                "UPDATE Course SET Available_Seats = Available_Seats + 1 " +
                        "WHERE Course_ID = ? AND Available_Seats < Capacity";

        try {
            conn.setAutoCommit(false);

            try {
                int courseId;

                try (PreparedStatement ps = conn.prepareStatement(find)) {
                    ps.setInt(1, registrationId);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) {
                            throw new SQLException(
                                    "Active registration not found.");
                        }

                        courseId = rs.getInt("Course_ID");
                    }
                }

                try (PreparedStatement ps = conn.prepareStatement(cancel)) {
                    ps.setInt(1, registrationId);

                    if (ps.executeUpdate() != 1) {
                        throw new SQLException("Cancellation failed.");
                    }
                }

                try (PreparedStatement ps = conn.prepareStatement(restore)) {
                    ps.setInt(1, courseId);

                    if (ps.executeUpdate() != 1) {
                        throw new SQLException("Seat restoration failed.");
                    }
                }

                logActivity("CANCEL_REGISTRATION",
                        "Registration ID: " + registrationId);

                conn.commit();
                System.out.println("Registration cancelled; seat restored.");

            } catch (Exception e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Cancellation failed.", e);
        }
    }

    // JOIN: REGISTRATIONS WITH STUDENT AND COURSE DETAILS
    public void viewRegistrations() {
        if (conn == null) {
            logger.severe("Database connection unavailable.");
            return;
        }

        String query =
                "SELECT r.Registration_ID, s.Student_Name, " +
                        "c.Course_Name, r.Registration_Date, r.Status " +
                        "FROM Registration r " +
                        "JOIN Student s ON r.Student_ID = s.Student_ID " +
                        "JOIN Course c ON r.Course_ID = c.Course_ID " +
                        "ORDER BY r.Registration_ID";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                        "Registration ID: " + rs.getInt("Registration_ID") +
                                ", Student: " + rs.getString("Student_Name") +
                                ", Course: " + rs.getString("Course_Name") +
                                ", Date: " + rs.getDate("Registration_Date") +
                                ", Status: " + rs.getString("Status")
                );
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Retrieving registrations failed.", e);
        }
    }

    // DISPLAY STUDENTS
    public void viewStudents() {
        if (conn == null) {
            logger.severe("Database connection unavailable.");
            return;
        }

        String query = "SELECT * FROM Student";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("Student_ID") + " | " +
                                rs.getString("Student_Name") + " | " +
                                rs.getString("Email") + " | " +
                                rs.getString("Phone")
                );
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Retrieving students failed.", e);
        }
    }

    // DISPLAY COURSES AND AVAILABLE SEATS
    public void viewCourses() {
        if (conn == null) {
            logger.severe("Database connection unavailable.");
            return;
        }

        String query = "SELECT * FROM Course";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("Course_ID") + " | " +
                                rs.getString("Course_Name") + " | Credits: " +
                                rs.getInt("Credits") + " | Seats: " +
                                rs.getInt("Available_Seats") + "/" +
                                rs.getInt("Capacity")
                );
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Retrieving courses failed.", e);
        }
    }

    // DISPLAY ACTIVITY LOG
    public void viewActivityLog() {
        if (conn == null) {
            logger.severe("Database connection unavailable.");
            return;
        }

        String query =
                "SELECT * FROM Activity_Log ORDER BY Activity_Time DESC";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("Log_ID") + " | " +
                                rs.getString("Activity") + " | " +
                                rs.getString("Details") + " | " +
                                rs.getTimestamp("Activity_Time")
                );
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Retrieving log failed.", e);
        }
    }
}
