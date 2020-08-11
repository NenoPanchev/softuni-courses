import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String allStops = scan.nextLine();
        String input = scan.nextLine();

        while (!"Travel".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < allStops.length()) {
                        String newStop = tokens[2];
                        String firstHalf = allStops.substring(0, index);
                        String secondHalf = allStops.substring(index);
                        allStops = firstHalf + newStop + secondHalf;
                    }
                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < allStops.length() &&
                    endIndex >= 0 && endIndex < allStops.length())
                    allStops = allStops.substring(0, startIndex) + allStops.substring(endIndex + 1);
                    break;

                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    allStops = allStops.replaceAll(oldString, newString);
                    break;
            }
            System.out.println(allStops);
            input = scan.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", allStops);
    }
}
