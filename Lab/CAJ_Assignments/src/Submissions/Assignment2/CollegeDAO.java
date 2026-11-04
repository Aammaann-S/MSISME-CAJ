package Submissions.Assignment2;

import java.sql.*;
import java.util.logging.*;

public class CollegeDAO {
    private Connection connection;
    private static final Logger logger = Logger.getLogger(CollegeDAO.class.getName());

    {
        try {
            FileHandler fh = new FileHandler("collegeApp.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) {
            System.out.println("Logging setup failed: " + e);
        }
    }

    public CollegeDAO() {
        connection = DBConnection.getConnection();
        if (connection == null) {
            System.out.println("Database connection is unavailable.");
        }
    }

    public void AddStudentRecord(int id, String name, String program, int semester, String email) {
        if (connection == null) {
            System.out.println("Database connection is unavailable.");
            logger.severe("Student Add failed. Database connection unavailable.");
            return;
        }

        String query = "INSERT INTO Student VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, program);
            ps.setInt(4, semester);
            ps.setString(5, email);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added successfully.");
                logger.info("Student Added. ID: " + id);
            } else {
                System.out.println("Student could not be added.");
                logger.warning("Student Add failed. ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Student Add failed:\n" + e);
            logger.severe("Student Add failed. ID: " + id + ". Error: " + e);
        }
    }

    public void UpdateStudentRecord(int id, String name, String program, int semester, String email) {
        if (connection == null) {
            System.out.println("Database connection is unavailable.");
            logger.severe("Student Update failed. Database connection unavailable.");
            return;
        }

        String query = "UPDATE Student SET Student_Name = ?, Program = ?, Semester = ?, Email = ? WHERE Student_ID = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, program);
            ps.setInt(3, semester);
            ps.setString(4, email);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated successfully.");
                logger.info("Student updated. ID: " + id);
            } else {
                System.out.println("No student found with ID: " + id);
                logger.warning("Student update failed. ID not found: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Student Update failed:\n" + e);
            logger.severe("Student Update failed. ID: " + id + ". Error: " + e);
        }
    }

    public void AddSubjectRecord(int id, String name, int credit, int semester) {
        if (connection == null) {
            System.out.println("Database connection is unavailable.");
            logger.severe("Subject Add failed. Database connection unavailable.");
            return;
        }

        String query = "INSERT INTO Subject VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, credit);
            ps.setInt(4, semester);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Subject Added successfully.");
                logger.info("Subject Added. ID: " + id);
            } else {
                System.out.println("Subject could not be added.");
                logger.warning("Subject Add failed. ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Subject Add failed:\n" + e);
            logger.severe("Subject Add failed. ID: " + id + ". Error: " + e);
        }
    }

    public void UpdateSubjectRecord(int id, String name, int credit, int semester) {
        if (connection == null) {
            System.out.println("Database connection is unavailable.");
            logger.severe("Subject Update failed. Database connection unavailable.");
            return;
        }

        String query = "UPDATE Subject SET Subject_Name = ?, Credits = ?, Semester = ? WHERE Subject_ID = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setInt(2, credit);
            ps.setInt(3, semester);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Subject Updated successfully.");
                logger.info("Subject Updated. ID: " + id);
            } else {
                System.out.println("No subject found with ID: " + id);
                logger.warning("Subject Update failed. ID not found: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Subject Update failed:\n" + e);
            logger.severe("Subject Update failed. ID: " + id + ". Error: " + e);
        }
    }

    public void AddExaminationRecord(int id, int subject_id, Date date, int marks) {
        if (connection == null) {
            System.out.println("Database connection is unavailable.");
            logger.severe("Examination Add failed. Database connection unavailable.");
            return;
        }

        String query = "INSERT INTO Examination VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.setInt(2, subject_id);
            ps.setDate(3, date);
            ps.setInt(4, marks);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Examination Record Added successfully.");
                logger.info("Examination Added. Exam ID: " + id);
            } else {
                System.out.println("Examination Record could not be added.");
                logger.warning("Examination Add failed. Exam ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Examination Add failed:\n" + e);
            logger.severe("Examination Add failed. Exam ID: " + id + ". Error: " + e);
        }
    }

    public void UpdateExaminationRecord(int id, int subject_id, Date date, int marks) {
        if (connection == null) {
            System.out.println("Database connection is unavailable.");
            logger.severe("Examination Update failed. Database connection unavailable.");
            return;
        }

        String query = "UPDATE Examination SET Subject_ID = ?, Exam_Date = ?, Max_Marks = ? WHERE Exam_ID = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, subject_id);
            ps.setDate(2, date);
            ps.setInt(3, marks);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Examination Record Updated successfully.");
                logger.info("Examination Updated. Exam ID: " + id);
            } else {
                System.out.println("No examination found with ID: " + id);
                logger.warning("Examination Update failed. Exam ID not found: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Examination Update failed:\n" + e);
            logger.severe("Examination Update failed. Exam ID: " + id + ". Error: " + e);
        }
    }

    public void EnterUpdateStudentMarks(int student_id, int exam_id, int marks, String grade) {
        if (connection == null) {
            System.out.println("Database connection is unavailable.");
            logger.severe("Saving Result failed. Database connection unavailable.");
            return;
        }

        String check = "SELECT Student_ID, Exam_ID FROM Result WHERE Student_ID = ? AND Exam_ID = ?";
        String insert = "INSERT INTO Result VALUES (?, ?, ?, ?)";
        String update = "UPDATE Result SET Marks_Obtained = ?, Grade = ? WHERE Student_ID = ? AND Exam_ID = ?";

        try {
            boolean exists;

            // Check whether a result already exists
            try (PreparedStatement ps = connection.prepareStatement(check)) {
                ps.setInt(1, student_id);
                ps.setInt(2, exam_id);

                try (ResultSet rs = ps.executeQuery()) {
                    exists = rs.next();
                }
            }

            int rows;

            if (exists) {
                // Update existing result
                try (PreparedStatement ps = connection.prepareStatement(update)) {
                    ps.setInt(1, marks);
                    ps.setString(2, grade);
                    ps.setInt(3, student_id);
                    ps.setInt(4, exam_id);

                    rows = ps.executeUpdate();
                }

                if (rows > 0) {
                    System.out.println("Student Result Marks Updated successfully.");
                    logger.info("Student Result Updated. Student ID: " + student_id + ", Exam ID: " + exam_id);
                } else {
                    System.out.println("Student Result could not be updated.");
                    logger.warning("Student Result Update failed.");
                }

            } else {
                // Insert new result
                try (PreparedStatement ps = connection.prepareStatement(insert)) {
                    ps.setInt(1, student_id);
                    ps.setInt(2, exam_id);
                    ps.setInt(3, marks);
                    ps.setString(4, grade);

                    rows = ps.executeUpdate();
                }

                if (rows > 0) {
                    System.out.println("Student Result Marks Added successfully.");
                    logger.info("Student Result Added. Student ID: " + student_id + ", Exam ID: " + exam_id);
                } else {
                    System.out.println("Student Result could not be added.");
                    logger.warning("Student Result Add failed.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Saving Result Failed:\n" + e);
            logger.severe("Saving Result failed. Error: " + e);
        }
    }

    public void calculateSubjectAverage() {
        if (connection == null) {
            System.out.println("Database connection is unavailable.");
            logger.severe("Average calculation failed. Database connection unavailable.");
            return;
        }

        String query = "SELECT s.Subject_ID, s.Subject_Name, " +
                "AVG(r.Marks_Obtained) AS Average_Marks " +
                "FROM Subject s " +
                "JOIN Examination e ON s.Subject_ID = e.Subject_ID " +
                "JOIN Result r ON e.Exam_ID = r.Exam_ID " +
                "GROUP BY s.Subject_ID, s.Subject_Name";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n===== SUBJECT-WISE AVERAGE MARKS =====");

            boolean found = false;

            while (rs.next()) {
                found = true;

                int subjectID = rs.getInt("Subject_ID");
                String subjectName = rs.getString("Subject_Name");
                double average = rs.getDouble("Average_Marks");

                System.out.println("Subject ID: " + subjectID +
                        ", Subject: " + subjectName +
                        ", Average Marks: " + String.format("%.2f", average));
            }

            if (!found) {
                System.out.println("No student results available to calculate averages.");
            }

            logger.info("Subject-wise average marks calculated.");

        } catch (SQLException e) {
            logger.severe("Error calculating subject averages: " + e);
            System.out.println("Error calculating averages: " + e);
        }
    }

    public void findHighestScoringStudents() {
        if (connection == null) {
            System.out.println("Database connection is unavailable.");
            logger.severe("Finding highest scorers failed. Database connection unavailable.");
            return;
        }

        String query = "SELECT s.Subject_Name, st.Student_ID, " +
                "st.Student_Name, r.Marks_Obtained " +
                "FROM Result r " +
                "JOIN Student st ON r.Student_ID = st.Student_ID " +
                "JOIN Examination e ON r.Exam_ID = e.Exam_ID " +
                "JOIN Subject s ON e.Subject_ID = s.Subject_ID " +
                "WHERE r.Marks_Obtained = (" +
                " SELECT MAX(r2.Marks_Obtained) " +
                " FROM Result r2 " +
                " JOIN Examination e2 ON r2.Exam_ID = e2.Exam_ID " +
                " WHERE e2.Subject_ID = e.Subject_ID" +
                ")";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n===== HIGHEST-SCORING STUDENTS =====");

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("Subject: " + rs.getString("Subject_Name") +
                        ", Student ID: " + rs.getInt("Student_ID") +
                        ", Student Name: " + rs.getString("Student_Name") +
                        ", Marks: " + rs.getInt("Marks_Obtained"));
            }

            if (!found) {
                System.out.println("No student results available.");
            }

            logger.info("Highest-scoring students retrieved.");

        } catch (SQLException e) {
            logger.severe("Error finding highest-scoring students: " + e);
            System.out.println("Error finding highest-scoring students: " + e);
        }
    }

    public void DisplayTable(String tableName) {

        if (connection == null) {
            System.out.println("Database connection is unavailable.");
            logger.severe("Display table failed. Database connection unavailable.");
            return;
        }

        // Allow only these predefined table names
        switch (tableName) {
            case "Student":
            case "Subject":
            case "Examination":
            case "Result":
                break;

            default:
                System.out.println("Invalid table name.");
                return;
        }

        String query = "SELECT * FROM " + tableName;

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();

            System.out.println("\n========== " + tableName.toUpperCase() + " TABLE ==========");

            // Display column names
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-22s", metadata.getColumnName(i));
            }

            System.out.println();
            System.out.println("--------------------------------------------------------------------------");

            boolean found = false;

            // Display table records
            while (rs.next()) {
                found = true;

                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-22s", rs.getObject(i));
                }

                System.out.println();
            }

            if (!found) {
                System.out.println("No records found in " + tableName + " table.");
            }

            logger.info("Displayed contents of " + tableName + " table.");

        } catch (SQLException e) {
            System.out.println("Unable to display table contents:\n" + e);
            logger.severe("Display table failed: " + e);
        }
    }
}
