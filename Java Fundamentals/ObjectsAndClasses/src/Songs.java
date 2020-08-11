import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Songs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        List<Song> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            List<String> input = Arrays.stream(scan.nextLine().split("_"))
                    .collect(Collectors.toList());
            Song currentSong = new Song();
            currentSong.setType(input.get(0));
            currentSong.name = input.get(1);
            currentSong.time = input.get(2);
            list.add(currentSong);
        }
        String type = scan.nextLine();

        for (int i = 0; i < num; i++) {
            if (type.equals("all")) {
                System.out.println(list.get(i).name);
            } else {
                if (list.get(i).type.equals(type))
                    System.out.printf("%s%n", list.get(i).name);
            }
        }
    }

    static class Song {
        public void setType(String type) {
            this.type = type;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public String getTime() {
            return time;
        }

        String type;
        String name;
        String time;
    }
}
