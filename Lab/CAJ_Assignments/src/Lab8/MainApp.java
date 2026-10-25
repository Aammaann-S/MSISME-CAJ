
package Lab8;

public class MainApp {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        dao.prepareDAO();

        System.out.println("\n===== TEST 1: INSERT EMPLOYEES =====");
        dao.insertEmployee(1001, "Abc", 50000);
        dao.insertEmployee(1002, "DEF", 30000);
        dao.insertEmployee(1003, "Rahul", 45000);
        dao.insertEmployee(1004, "Priya", 60000);

        System.out.println("\n===== TEST 2: FETCH ALL EMPLOYEES =====");
        dao.fetchAllEmployee();

        System.out.println("\n===== TEST 3: UPDATE EXISTING EMPLOYEE =====");
        dao.updateEmployee(1002, "Deepak", 35000);

        System.out.println("\n===== TEST 4: VERIFY UPDATED RECORD =====");
        dao.fetchAllEmployee();

        System.out.println("\n===== TEST 5: UPDATE NON-EXISTENT EMPLOYEE =====");
        dao.updateEmployee(9990, "Unknown", 10000);

        System.out.println("\n===== TEST 6: DELETE EXISTING EMPLOYEE =====");
        dao.deleteEmployee(1003);

        System.out.println("\n===== TEST 7: DELETE NON-EXISTENT EMPLOYEE =====");
        dao.deleteEmployee(9990);

        System.out.println("\n===== TEST 8: VERIFY AFTER DELETION =====");
        dao.fetchAllEmployee();
    }
}
