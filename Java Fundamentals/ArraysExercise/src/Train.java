import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wagons = Integer.parseInt(scan.nextLine());
        int[] people = new int[wagons];
        int total = 0;
        String stri = "";
        for (int i : people) {
            int current = Integer.parseInt(scan.nextLine());
            stri = stri + current + " ";
            total+= current;
        }
        System.out.println(stri);
        System.out.println(total);
    }
}
