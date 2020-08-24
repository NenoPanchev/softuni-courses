package BookComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    String title;
    int year;
    List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<String>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    @Override
    public int compareTo(Book other) {
        if (this.title.compareTo(other.title) != 0) {
            return this.title.compareTo(other.title);
        } else {
            return Integer.compare(this.year, other.year);
        }
    }
}
