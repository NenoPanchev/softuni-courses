import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());
        Collections.reverse(list);

        String toPrint = list.toString().replaceAll("[\\]\\[,]", "").trim();
        toPrint = toPrint.replaceAll("\\s+", " ");
        System.out.println(toPrint);
    }
}
