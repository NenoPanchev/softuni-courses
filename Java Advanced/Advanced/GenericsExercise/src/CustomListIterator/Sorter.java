package CustomListIterator;

public class Sorter <E extends Comparable<E>>{

    public void sort(CustomList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            E element = list.get(i);
            for (int j = 0; j < list.size() - 1; j++) {
                if (element.compareTo(list.get(j)) < 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
