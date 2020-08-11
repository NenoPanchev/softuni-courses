import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] arr = input.split("\\s+");

            if (!arr[2].equals("not")) {
                if (guests.size() == 0)
                    guests.add(arr[0]);
                else {
                    checkAndAddName(guests, arr[0]);
                }
            } else {
                if (guests.size() == 0)
                    System.out.printf("%s is not in the list!%n", arr[0]);
                else {
                    checkAndRemoveName(guests, arr[0]);
                }
            }
        }
        for (String guest : guests) {
            System.out.println(guest);
        }

    }

    static void checkAndRemoveName(List<String> guests, String name) {
        for (int j = 0; j < guests.size(); j++) {
            if (name.equals(guests.get(j))) {
                guests.remove(name);
                return;
            }
        }
        System.out.printf("%s is not in the list!%n", name);
    }
    static void checkAndAddName(List<String> guests, String name) {
        for (int j = 0; j < guests.size(); j++) {
            if (name.equals(guests.get(j))) {
                System.out.printf("%s is already in the list!%n", name);
                return;
            }
        }
        guests.add(name);
    }
}
