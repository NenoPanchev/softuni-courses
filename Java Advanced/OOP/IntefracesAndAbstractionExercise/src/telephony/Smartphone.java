package telephony;

import java.util.List;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers) {
            if (isValidNumber(number)) {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : this.urls) {
            if (isValidURL(url)) {
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    private boolean isValidURL(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}