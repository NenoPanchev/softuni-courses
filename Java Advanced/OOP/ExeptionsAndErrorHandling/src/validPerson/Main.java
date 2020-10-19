package validPerson;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("4avdar", "Asd", 19);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
