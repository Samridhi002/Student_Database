import java.sql.*;


public class ResultDAO {
    static Connection connection = Database_Connection.getConnection();

    public static void addResults(Result result) throws SQLException {

        String sql = "INSERT INTO Student.S_Results (s_id, subject1, subject2, subject3, subject4, subject5) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, result.getSid());

            st.setDouble(2, result.getS1());
            st.setDouble(3, result.getS2());
            st.setDouble(4, result.getS3());
            st.setDouble(5, result.getS4());
            st.setDouble(6, result.getS5());

            int rows = st.executeUpdate();
            System.out.println(rows + " row(s) inserted");
        }
    }

    public static void getResults() throws SQLException {
        String sql = "SELECT * FROM Student.S_Results";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println("Result ID: " + resultSet.getInt("r_id"));
                System.out.println("Roll number: " + resultSet.getInt("s_id"));
                for (int i = 1; i <= 5; i++) {
                    System.out.printf("Subject %d: %.2f%n", i, resultSet.getDouble("subject" + i));
                }
                System.out.println("--------------------");
            }
        }
    }

//    public static void main(String[] args) throws SQLException {
//        addResults();
//        getResults();
//    }
}