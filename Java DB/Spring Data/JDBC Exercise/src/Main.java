import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Homework homework = setUp();
        start(homework);
    }
    private static Homework setUp() throws SQLException {
        System.out.println("Hello, fellow student!\r\n" +
                "First make sure you have your 'minions_db' database, then \r\n" +
                "Enter your MySQL user:");
        String user = scan.nextLine();
        System.out.println("Enter your MySQL password:");
        String password = scan.nextLine();
        return new Homework(user, password);
    }
    private static void start(Homework homework) throws SQLException {
        while (true) {
            System.out.println("Enter the number of problem you wish to check or 0 to exit:");
            int problem = Integer.parseInt(scan.nextLine());

            switch (problem) {
                case 0:
                    System.out.println("Goodbye! :)");
                    System.exit(0);
                case 2:
                    homework.getVillainsNamesEx2();
                    break;
                case 3:
                    homework.getMinionNamesEx3();
                    break;
                case 4:
                    homework.addMinionEx4();
                    break;
                case 5:
                    homework.changeTownNamesCasingEx5();
                    break;
                case 6:
                    homework.removeVillainEx6();
                    break;
                case 7:
                    homework.printAllMinionNamesEx7();
                    break;
                case 8:
                    homework.increaseMinionsAgeEx8();
                    break;
                case 9:
                    homework.increaseAgeStoredProcedureEx9();
                    break;
                default:
                    System.out.println("Incorrect number. Try again.");
            }
            System.out.println();
        }
    }
}
