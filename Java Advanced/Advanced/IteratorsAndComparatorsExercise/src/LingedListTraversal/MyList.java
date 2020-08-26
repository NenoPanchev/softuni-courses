package LingedListTraversal;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyList<E> implements Iterable<E> {
    private Node<E> first;
    private int size = 0;



    private class Node<E> {
        private E value;
        private Node<E> next;

        Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getNext() {
            return next;
        }
    }

    public MyList() {
    }

    public void add(E element) {
        size++;
        Node<E> node = new Node<>(element);
        if (first == null) {
            this.first = node;
            return;
        }
        Node<E> currentNode = first;
        while (currentNode != null) {
            if (currentNode.next == null) {
                currentNode.next = node;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    public void remove(E element) {
        forEach(e -> {

        });
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return first.getNext() != null;
            }

            @Override
            public E next() {
                return first.getNext().value;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        for (E e : this) {
            action.accept(e);
        }
    }
}
