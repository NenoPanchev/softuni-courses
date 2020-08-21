package GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Object[] numbers = ArrayCreator.create(4, 0);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        Object[] strings = ArrayCreator.create(String.class, 5, "asd");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
