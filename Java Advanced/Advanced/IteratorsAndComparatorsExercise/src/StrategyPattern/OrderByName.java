package StrategyPattern;

import java.util.Comparator;

public class OrderByName implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int sort = first.getName().length() - second.getName().length();
        if (sort == 0) {
            sort = first.getName().toLowerCase().charAt(0) - second.getName().toLowerCase().charAt(0);
        }
        return sort;
    }
}
