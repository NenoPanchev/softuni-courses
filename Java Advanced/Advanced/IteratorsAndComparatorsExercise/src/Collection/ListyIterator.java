package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int index;

    public ListyIterator(String... list) {
        this.setList(list);
    }

    public List<String> getList() {
        return list;
    }

    public void setList(String... list) {
        this.list = new ArrayList<>(Arrays.asList(list));
    }


    public boolean hasNext() {
        return this.index < list.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public int getIndex() {
        return this.index;
    }

    public void print() {
        try {
            System.out.println(this.list.get(getIndex()));
        } catch (Exception e){
            System.out.println("Invalid Operation!");
        }
    }
    
    public void printAll() {
        for (String s : list) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < list.size() - 1;
            }

            @Override
            public String next() {
                return list.get(index++);
            }
        };
    }
}

