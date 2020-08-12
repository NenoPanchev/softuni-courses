import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "input.txt";
        String file = "src/CopyBytes.txt";
        try ( FileInputStream inputStream = new FileInputStream(path);
              FileOutputStream outputStream = new FileOutputStream(file)){
            int oneByte = inputStream.read();

            while (oneByte >= 0) {
                if ((char) oneByte == ' ' || (char) oneByte == '\n') {
                    outputStream.write(oneByte);
                } else {
                    String valueASCII = String.valueOf(oneByte);
                    for (int i = 0; i < valueASCII.length(); i++) {
                       outputStream.write(valueASCII.charAt(i));
                    }
                }
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
