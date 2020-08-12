import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "input.txt";
        String output = "src/ExtractIntegers.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Scanner scan = new Scanner(inputStream);
        FileOutputStream outputStream = new FileOutputStream(output);
        PrintWriter printWriter = new PrintWriter(outputStream);
        try {

            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    int oneInt = scan.nextInt();
                    printWriter.println(oneInt);
                } else
                    scan.next();
            }
        } finally {
            scan.close();
            printWriter.close();
        }

    }
}
