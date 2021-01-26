package diablo;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Connection connection = setConnection("root", "12345");

        System.out.println("Enter username:");
        String username = scan.nextLine();
        executeQuery(connection, username);
    }

    public static Connection setConnection(String user, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);
    }

    public static void executeQuery(Connection connection, String username) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT u.first_name, u.last_name, COUNT(ug.id) AS games_count\n" +
                "FROM users AS u\n" +
                "JOIN users_games ug on u.id = ug.user_id\n" +
                "WHERE last_name = ?\n" +
                "GROUP BY u.id;");
        statement.setString(1, username);

        ResultSet rs = statement.executeQuery();
        if (!rs.next()) {
            System.out.println("No such user exists");
        } else {
            while (rs.next()) {
                System.out.printf("User: %s%n" +
                                "%s %s has played %d games%n",
                        username,
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("games_count"));
            }
        }
    }
}
    