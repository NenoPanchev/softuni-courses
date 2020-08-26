package StackIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Stack implements Iterable<Integer> {
    List<Integer> stack;

    public Stack(Integer... list) {
        this.setStack(list);
    }

    public void setStack(Integer... list) {
        this.stack = new ArrayList<>(Arrays.asList(list));
    }

    public Integer pop() {
        Integer numberToPop = iterator().next();
        stack.remove(stack.size() - 1);
        return numberToPop;
    }

    public void push(Integer num) {
        stack.add(num);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = stack.size() - 1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return stack.get(index--);
                } else
                    return null;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterator<Integer> iterator = this.iterator();
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }
}
