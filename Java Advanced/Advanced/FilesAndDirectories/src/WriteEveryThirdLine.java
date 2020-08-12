import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        String output = "src/WriteEveryThirdLine.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(path));
             PrintWriter out = new PrintWriter(new FileOutputStream(output))
        ) {
            String line = in.readLine();
            int countLines = 1;
            while (line != null) {
                if (countLines % 3 == 0)
                    out.println(line);
                countLines++;
                line = in.readLine();
            }
        }
    }
}
