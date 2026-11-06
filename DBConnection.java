
package cite_lostandfounddepartment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/cite_lostandfounddepartment_system";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {

            System.out.println("Database connection error: " + e.getMessage());
        }
        return conn;
    }
}
