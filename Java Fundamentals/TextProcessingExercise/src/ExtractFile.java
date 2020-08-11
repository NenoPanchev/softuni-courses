import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String filePath = scan.nextLine();
        StringBuilder fileName = new StringBuilder();
        StringBuilder extension = new StringBuilder();

        int nameStart = filePath.lastIndexOf("\\");
        int extensionStart = filePath.lastIndexOf(".");
        fileName.append(filePath, nameStart + 1, extensionStart);
        extension.append(filePath.substring(extensionStart + 1));
        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s%n", extension);
    }
}
