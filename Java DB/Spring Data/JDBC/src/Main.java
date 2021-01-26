import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Homework homework = new Homework(scan);
        homework.setConnection("root", "12345");
        homework.executePreparedStatement();

    }
}
