import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalNeededExperience = Double.parseDouble(scan.nextLine());
        int numberOfBattles = Integer.parseInt(scan.nextLine());
        int countOfBattles = 0;
        for (int i = 1; i <= numberOfBattles; i++) {
            double currentExp = Double.parseDouble(scan.nextLine());
            double bonus = 1;
            countOfBattles++;
            if (countOfBattles % 3 == 0)
                bonus = 1.15;
            else if (countOfBattles % 5 == 0)
                bonus = 0.9;
            totalNeededExperience -= currentExp * bonus;
            if (totalNeededExperience <= 0)
                break;
        }
        if (totalNeededExperience > 0)
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.%n",
                    totalNeededExperience);
        else
            System.out.printf("Player successfully collected his needed experience for %d battles.%n",
                    countOfBattles);
    }
}
