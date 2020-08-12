import java.io.File;
import java.util.ArrayDeque;
import java.util.List;

public class NestedFolders {
    public static void main(String[] args) {
        String path = "04. Java-Advanced-Files-and-Streams-Lab-Resources";
        File dir = new File(path);
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(dir);
        int folders = 0;

        while (!queue.isEmpty()) {
            File currentDir = queue.poll();
            System.out.println(currentDir.getName());
            File[] files = currentDir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    queue.offer(file);
                    folders++;
                }
            }
        }
        System.out.println(folders + " folders");
    }
}
