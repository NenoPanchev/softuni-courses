import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        double maxRating = - 1000000000;
        double minRating = 1000000000;
        String maxName = "";
        String minName = "";
        double ratingSum = 0;

        for (int i = 1; i <= num; i++){
            String name = scan.nextLine();
            double rating = Double.parseDouble(scan.nextLine());
            if (rating > maxRating){
                maxRating = rating;
                maxName = name;
            }
            if (rating < minRating){
                minRating = rating;
                minName = name;
            }
            ratingSum += rating;
        }
        System.out.printf("%s is with highest rating: %.1f%n", maxName, maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n", minName, minRating);
        System.out.printf("Average rating: %.1f", ratingSum / num);
    }

}
