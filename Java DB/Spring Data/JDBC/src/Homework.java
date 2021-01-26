import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Homework {
    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/";
    private static final String SOFT_UNI_TABLE_NAME = "soft_uni";
    private Connection connection;
    private Scanner scan;

    public Homework(Scanner scan) {
        this.scan = scan;
    }

    public void setConnection(String user, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        this.connection = DriverManager
                .getConnection(CONNECTION_STRING + SOFT_UNI_TABLE_NAME, properties);
    }

    public void executePreparedStatement() throws SQLException {
        PreparedStatement stmt =
                connection.prepareStatement("SELECT first_name, last_name FROM employees WHERE salary > ?");
        System.out.println("Enter salary:");
        double salary = Double.parseDouble(scan.nextLine());
        stmt.setDouble(1, salary);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    }

}
