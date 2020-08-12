import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] robotsData = scan.nextLine().split(";");
        LinkedHashMap<String, Integer> robotProcessTime = new LinkedHashMap<>();
        String[] robotsArray = new String[robotsData.length];
        int[] timeLeft = new int[robotsData.length];
        for (int i = 0; i < robotsData.length; i++) {
            String[] token = robotsData[i].split("-");
            robotsArray[i] = token[0];
            robotProcessTime.put(token[0], Integer.parseInt(token[1]));
        }
        String[] startingTime = scan.nextLine().split(":");
        int hours = Integer.parseInt(startingTime[0]);
        int minutes = Integer.parseInt(startingTime[1]);
        int seconds = Integer.parseInt(startingTime[2]);
        long totalSeconds = hours * 3600 + minutes * 60 + seconds;

        String product = scan.nextLine();
        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        while (!"End".equals(product)) {
            productsQueue.offer(product);
            product = scan.nextLine();
        }


        while (!productsQueue.isEmpty()) {
            totalSeconds += 1;
            long printHours = (totalSeconds / 3600) % 24;
            long printMinutes = (totalSeconds % 3600) / 60;
            long printSeconds = totalSeconds % 60;
            String currentProduct = productsQueue.poll();
            boolean checkIfShouldOffer = true;
            for (int i = 0; i < timeLeft.length; i++) {
                    timeLeft[i]--;

                int remainingTime = timeLeft[i];
                String name = robotsArray[i];
                int initialTime = robotProcessTime.get(name);
                if (remainingTime <= 0 && checkIfShouldOffer){
                    timeLeft[i] = initialTime;
                    checkIfShouldOffer = false;
                    System.out.printf("%s - %s [%02d:%02d:%02d]%n", name, currentProduct, printHours, printMinutes, printSeconds);

                }
            }
            if (checkIfShouldOffer) {
                productsQueue.offer(currentProduct);
            }

        }
    }
}
