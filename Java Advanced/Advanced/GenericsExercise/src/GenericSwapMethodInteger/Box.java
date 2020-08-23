package GenericSwapMethodInteger;

import java.util.Collections;
import java.util.List;

public class Box<T> {
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
}
