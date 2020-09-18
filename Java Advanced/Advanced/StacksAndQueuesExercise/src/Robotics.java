import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] robotsData = scan.nextLine().split(";");
        Robot[] robots = new Robot[robotsData.length];
        for (int i = 0; i < robotsData.length; i++) {
            String[] token = robotsData[i].split("-");
            Robot robot = new Robot(token[0], Integer.parseInt(token[1]));
            robots[i] = robot;
        }
        String[] startingTime = scan.nextLine().split(":");
        int hours = Integer.parseInt(startingTime[0]);
        int minutes = Integer.parseInt(startingTime[1]);
        int seconds = Integer.parseInt(startingTime[2]);
        long totalSeconds = hours * 3600 + minutes * 60 + seconds;

        String product = scan.nextLine();
        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        while (!"End".equals(product)) {
            productsQueue.push(product);

            totalSeconds += 1;
            checkIfRobotIsFreeAndGiveItItem(robots, totalSeconds, productsQueue);
            product = scan.nextLine();
        }
        while (!productsQueue.isEmpty()) {
            totalSeconds += 1;
            checkIfRobotIsFreeAndGiveItItem(robots, totalSeconds, productsQueue);
        }
    }

    private static void checkIfRobotIsFreeAndGiveItItem(Robot[] robots, long totalSeconds, ArrayDeque<String> productsQueue) {
        boolean productTaken = false;

        for (Robot robot : robots) {
            robot.reduceTimeLeft();
            if (robot.isFree() && !productTaken) {
                String currentProduct = productsQueue.pop();
                robot.setTimeLeftUntilFree();
                productTaken = true;
                System.out.printf("%s - %s [%02d:%02d:%02d]%n",
                        robot.getName(),
                        currentProduct,
                        (totalSeconds / 3600) % 24,
                        (totalSeconds % 3600) / 60,
                        totalSeconds % 60);
            }
        }
    }
}

class Robot {
    private String name;
    private int initialProcessingTime;
    private int timeLeftUntilFree;

    public Robot(String name, int initialProcessingTime) {
        this.name = name;
        this.initialProcessingTime = initialProcessingTime;
        this.timeLeftUntilFree = 0;
    }

    public void reduceTimeLeft() {
        this.timeLeftUntilFree--;
    }
    public boolean isFree() {
        return timeLeftUntilFree <= 0;
    }

    public String getName() {
        return this.name;
    }

    public void setTimeLeftUntilFree() {
        this.timeLeftUntilFree = this.initialProcessingTime;
    }
}
