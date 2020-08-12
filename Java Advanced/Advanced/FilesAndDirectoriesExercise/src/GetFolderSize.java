import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "Exercises Resources";
        File file = new File(path);
        long size = 0;
        for (File listFile : file.listFiles()) {
            size += listFile.length();
        }
        System.out.printf("Folder size: %d%n", size);
    }
}
