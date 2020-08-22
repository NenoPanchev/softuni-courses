package GenericCountMethodDouble;

import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value
                .getClass()
                .getName()
                + ": " + value;
    }

    public static <T> void swap(List<T> list, int firstIndex, int secondIndex) {
        Collections.swap(list, firstIndex, secondIndex);
    }

    public static <T extends Comparable<T>> int getCountOfBiggerElements(List<T> list, T element) {
        return (int) list.stream()
                .filter(x -> x.compareTo(element) > 0).count();
    }
}
