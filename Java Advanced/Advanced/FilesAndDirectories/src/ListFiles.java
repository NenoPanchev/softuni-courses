import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ListFiles {
    public static void main(String[] args) {
        String path = "Files-and-Streams";
        File file = new File(path);
        List<File> list = List.of(file.listFiles(File::isFile));
        for (File file1 : list) {
            System.out.printf("%s: [%d]%n", file1.getName(), file1.length());
        }
    }
}
