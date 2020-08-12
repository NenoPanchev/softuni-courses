import java.io.*;

public class CountCharTypes {
    public static void main(String[] args) {
        String path = "input.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(path))){
            String line = in.readLine();
            int vowels = 0;
            int consonants = 0;
            int punctuation = 0;
            while (line != null) {
                String vow = "aeiou";
                String punct = "!,.?";
                line = line.replaceAll("\\s+", "");
                String[] chars = line.split("");
                for (String c : chars) {
                    if (vow.contains(c)) {
                        vowels++;
                    } else if (punct.contains(c)) {
                        punctuation++;
                    } else
                        consonants++;
                }
                line = in.readLine();
            }
            System.out.printf("Vowels: %d%nConsonants: %d%nPunctuation: %d%n", vowels, consonants, punctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
