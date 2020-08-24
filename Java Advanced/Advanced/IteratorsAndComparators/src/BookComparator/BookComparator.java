package BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        int sort = first.getTitle().compareTo(second.getTitle());
        if (sort == 0) {
            sort = Integer.compare(first.getYear(), second.getYear());
        }
        return sort;
    }
}
