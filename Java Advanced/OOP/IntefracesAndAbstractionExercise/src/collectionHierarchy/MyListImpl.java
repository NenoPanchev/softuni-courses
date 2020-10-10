package collectionHierarchy;

import collectionHierarchy.Collection;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int add(String item) {
        this.getItems().add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        String itemToReturn = this.getItems().get(0);
        this.getItems().remove(itemToReturn);
        return itemToReturn;
    }

    @Override
    public int getUsed() {
        return this.getItems().size();
    }
}
