import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> studentGrades = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            studentGrades.putIfAbsent(name, new ArrayList<>());
            studentGrades.get(name).add(grade);
        }
        studentGrades.entrySet()
                .forEach(x-> {
        //    double avg = x.getValue().stream().mapToDouble(d -> d).average().orElse(0);
                    double avg = 0;
                    for (Double n : x.getValue()) {
                        avg += n;
                    }
                    avg /= x.getValue().size();
                    System.out.printf("%s -> ", x.getKey());
                    x.getValue().forEach(v -> System.out.printf("%.2f ", v));
                    System.out.printf("(avg: %.2f)%n", avg);
        });
    }
}
