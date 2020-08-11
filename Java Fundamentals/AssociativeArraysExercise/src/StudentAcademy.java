import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();

        for (int i = 0; i < num; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            studentGrades.putIfAbsent(name, new ArrayList<>());
            studentGrades.get(name).add(grade);
        }
        studentGrades.entrySet()
                .stream()
                .filter(entry -> entry.getValue().stream().mapToDouble(d -> d).average().orElse(0.0) >= 4.5)
                .sorted((a, b) -> Double.compare(b.getValue().stream().mapToDouble(d -> d).average().orElse(0.),
                        a.getValue().stream().mapToDouble(d -> d).average().orElse(0.0)))
                .forEach(entry -> {
                    System.out.printf("%s -> ", entry.getKey());
                    System.out.printf("%.2f%n", entry.getValue().stream().mapToDouble(d -> d).average().orElse(0.0));
                });
    }
}
