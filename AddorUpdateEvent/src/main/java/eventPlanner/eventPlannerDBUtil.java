package eventPlanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class eventPlannerDBUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/oeps";
    private static final String USER = "root";
    private static final String PASS = "Shehan@24700";
    
    // Method to establish and return a connection to the database
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure the MySQL driver is loaded
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver not found");
        }
    }
}
