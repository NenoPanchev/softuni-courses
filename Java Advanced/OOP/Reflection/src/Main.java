import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> reflection = Reflection.class;
        Field[] fields = Reflection.class.getDeclaredFields();
        Method[] methods = reflection.getDeclaredMethods();
//        Arrays.stream(methods)
//                .filter(m -> m.getName().startsWith("get"))
//                .sorted(Comparator.comparing(Method::getName))
//                .forEach(method -> System.out.printf("%s will return class %s%n",
//                        method.getName(), method.getReturnType().getName()));
//
//        Arrays.stream(methods)
//                .filter(m -> m.getName().startsWith("set"))
//                .filter(method -> method.getParameterCount() == 1)
//                .sorted(Comparator.comparing(Method::getName))
//                .forEach(method -> System.out.printf("%s and will set field of class %s%n",
//                        method.getName(), method.getParameterTypes()[0].getName()));

        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be public!%n",
                        method.getName(), method.getReturnType().getName()));

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be private!%n",
                        method.getName(), method.getReturnType().getName()));
    }
}
