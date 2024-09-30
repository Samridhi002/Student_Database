import java.sql.*;

public class StudentDAO {
    static Connection connection = Database_Connection.getConnection();

    // Method to add a student record to the database
    public static void addStudent(Student student) throws SQLException {

        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("INSERT INTO Student.S_info (s_id, s_name, age, course) VALUES (?, ?, ?, ?)");
            st.setInt(1, student.getS_id());
            st.setString(2, student.getS_name());
            st.setInt(3, student.getAge());
            st.setString(4, student.getCourse());

            // Execute update
            int rows = st.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } finally {
            // Close PreparedStatement
            if (st != null) st.close();
        }
    }

    // Method to retrieve student details from the database
    public static void getDetails(Student student) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Student.S_info");

            // Fetching data and displaying the results
            System.out.println("Student Details:");
            while (resultSet.next()) {
                student.setS_id(resultSet.getInt("s_id")) ;
                student.setS_name(resultSet.getString("s_name"));
                student.setAge(resultSet.getInt("age"));
                student.setCourse(resultSet.getString("course"));

                // Display the data
                student.toString();
            }
       } finally {
            // Close ResultSet and Statement
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        }
    }
//    public static void main(String[] args) throws SQLException {
//        Student s = new Student();
//        StudentDAO st = new StudentDAO();
//        st.addStudent(s);
//        st.getDetails(s);
//    }
}
