package Lab.JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> data;

    public Jar() {
        this.data = new ArrayDeque<>();
    }

    public void add(T element) {
        this.data.push(element);
    }

    public T remove() {
        return this.data.poll();
    }
}
