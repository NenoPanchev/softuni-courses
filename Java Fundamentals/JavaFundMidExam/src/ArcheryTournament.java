import java.util.*;
import java.util.stream.Collectors;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\|"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scan.nextLine();
        int points = 0;
        while (!input.equals("Game over")) {
            String[] command = input.split("\\s+");
            if (command[0].equals("Shoot")) {
                String[] direction = command[1].split("@");
                int startIndex = Integer.parseInt(direction[1]);
                int length = Integer.parseInt(direction[2]);
                int index = 0;
                if (startIndex >= 0 && startIndex < list.size()) {
                    if (direction[0].equals("Left")) {
                        index = startIndex - length % list.size();
                        if (index < 0)
                            index = list.size() + index;
                    } else if (direction[0].equals("Right")) {
                        index = startIndex + length % list.size();
                        if (index >= list.size())
                            index -= list.size();
                    }
                    if (list.get(index) >= 5) {
                        list.set(index, list.get(index) - 5);
                        points += 5;
                    } else {
                        points += list.get(index);
                        list.set(index, 0);
                    }
                }
            } else if (command[0].equals("Reverse"))
                Collections.reverse(list);

            input = scan.nextLine();
        }
        StringBuilder joined = new StringBuilder();
        joined.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            joined.append(" - ");
            joined.append(list.get(i));
        }
        System.out.println(joined);
        System.out.printf("Iskren finished the archery tournament with %d points!", points);
    }
}
