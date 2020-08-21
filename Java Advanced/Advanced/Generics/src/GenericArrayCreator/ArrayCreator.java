package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {
@SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T element) {
        T[] array = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            array[i] = element;
        }
        return array;
    }
@SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> clazz, int length, T element) {
        T[] result = (T[]) Array.newInstance(clazz, length);
        for (int j = 0; j < length; j++) {
            result[j] = element;
        }
        return result;
    }
}
