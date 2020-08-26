package ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
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
}

