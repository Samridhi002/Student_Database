
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connection {
        private static final String URL = "jdbc:mysql://localhost:3306/Student";
        private static final String USER = "root";
        private static final String PASSWORD = "root";

        public static Connection getConnection () {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection established successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
}
