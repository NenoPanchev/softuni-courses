import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        TreeMap<String, ArrayList<Double>> studentGrades = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            String name = scan.nextLine();
            ArrayList<Double> grades = (ArrayList<Double>) Arrays.stream(scan.nextLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());
            studentGrades.put(name, grades);
        }
        studentGrades.entrySet()
                .forEach(s -> {
                    double total = 0;
                    for (Double numb : s.getValue()) {
                        total += numb;
                    }
                    double average = total / s.getValue().size();
                    System.out.printf("%s is graduated with %s%n", s.getKey(), average);
                });
    }
}
