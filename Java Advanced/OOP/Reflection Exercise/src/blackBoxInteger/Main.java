package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
    Scanner scan = new Scanner(System.in);
    Class<BlackBoxInt> reflectionBlackBox = BlackBoxInt.class;
    Constructor<BlackBoxInt> constructor = reflectionBlackBox.getDeclaredConstructor();
    constructor.setAccessible(true);
    BlackBoxInt blackBoxInstance = constructor.newInstance();


    String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String operation = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            Method[] methods = Arrays.stream(blackBoxInstance.getClass().getDeclaredMethods())
                    .toArray(Method[]::new);
            for (Method method : methods) {
                if (method.getName().equals(operation)) {
                    method.setAccessible(true);
                    method.invoke(blackBoxInstance, value);
                }
            }
            Field field = blackBoxInstance.getClass().getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInstance));
            input = scan.nextLine();
        }
    }
}
