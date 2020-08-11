import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int num = Integer.parseInt(scan.nextLine());
        int total = num *3;
        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, total, num);
    }
}
