package createAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Foo> reflectionFoo = Foo.class;
        Method[] methods = reflectionFoo.getMethods();

        Foo fooInstance = reflectionFoo.getConstructor().newInstance();

    }
}
