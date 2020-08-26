package Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake implements Iterable<Integer> {
    int[] list;

    public Lake(int... numbers) {
        this.list = Arrays.stream(numbers).toArray();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < list.length;
            }

            @Override
            public Integer next() {
                int current = list[index];

                if (list.length % 2 == 0 && index == list.length - 2) {
                    index = -1;
                } else if (list.length % 2 != 0 && index == list.length - 1) {
                    index = -1;
                }
                index += 2;
                return current;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (Integer integer : this) {
            action.accept(integer);
        }
    }

    @Override
    public String toString() {
        List<Integer> arrayToPrint = new ArrayList<>();
        forEach(arrayToPrint::add);
        return arrayToPrint.toString().replaceAll("[\\[\\]]", "");
    }
}
