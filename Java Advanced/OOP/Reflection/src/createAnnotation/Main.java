package createAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<TestClass> reflectionFoo = TestClass.class;
        Method[] methods = reflectionFoo.getMethods();

        TestClass testClassInstance = reflectionFoo.getConstructor().newInstance();

    }
}
