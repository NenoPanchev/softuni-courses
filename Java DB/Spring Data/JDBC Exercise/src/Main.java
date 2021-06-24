import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Homework homework = setUp();
        start(homework);
    }
    private static Homework setUp() throws SQLException {
        System.out.println("Здравей, колега!\r\n" +
                "Първо се увери, че имаш базата 'minions_db' и след това \r\n" +
                "Въведи своя MySQL user:");
        String user = scan.nextLine();
        System.out.println("Въведи своята MySQL password:");
        String password = scan.nextLine();
        return new Homework(user, password);
    }
    private static void start(Homework homework) {
        while (true) {
            System.out.println("Въведи номера на задачата, която искаш да провериш или 0 за изход:");
            int problem = Integer.parseInt(scan.nextLine());

            try {
                switch (problem) {
                    case 0:
                        System.out.println("Довиждане! :)");
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
                        System.out.println("Грешен номер. Опитай отново.");
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            System.out.println();
        }
    }
}
