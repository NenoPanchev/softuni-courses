package collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private final int maxSize = 100;
    private List<String> items;

    protected Collection() {
        this.items = new ArrayList<>(maxSize);
    }

    public List<String> getItems() {
        return this.items;
    }
}
