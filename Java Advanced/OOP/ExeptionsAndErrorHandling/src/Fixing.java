public class Fixing {
    public static void main(String[] args) {
        String[] weekdays = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        for (int i = 0; i <= weekdays.length; i++) {
            try {
                System.out.println(weekdays[i]);
            } catch (IndexOutOfBoundsException e) {
                System.out.printf("Index out of bounds for index: %d and length: %d", i, weekdays.length);
                break;
            }

        }
    }
}
