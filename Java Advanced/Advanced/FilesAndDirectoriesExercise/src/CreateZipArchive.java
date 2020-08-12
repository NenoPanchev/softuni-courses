import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        String first = "inputOne.txt";
        String second = "inputTwo.txt";
        String third = "words.txt";
        String output = "files.zip";

        try (FileInputStream firstInput = new FileInputStream(first);
             FileInputStream secondInput = new FileInputStream(second);
             FileInputStream thirdInput = new FileInputStream(third);
             ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(output))){

            int byteContainer;
            zipOutputStream.putNextEntry(new ZipEntry(first));
            while ((byteContainer = firstInput.read()) != -1) {
                zipOutputStream.write(byteContainer);
            }
            zipOutputStream.closeEntry();

            zipOutputStream.putNextEntry(new ZipEntry(second));
            while ((byteContainer = secondInput.read()) != -1) {
                zipOutputStream.write(byteContainer);
            }
            zipOutputStream.closeEntry();

            zipOutputStream.putNextEntry(new ZipEntry(third));
            while ((byteContainer = thirdInput.read()) != -1) {
                zipOutputStream.write(byteContainer);
            }
            zipOutputStream.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
