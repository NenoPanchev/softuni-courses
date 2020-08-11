import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalPeople = Integer.parseInt(scan.nextLine());
        int perCourse = Integer.parseInt(scan.nextLine());
        int courses = (int) Math.ceil((double) totalPeople / perCourse);
        System.out.println(courses);
    }
}
