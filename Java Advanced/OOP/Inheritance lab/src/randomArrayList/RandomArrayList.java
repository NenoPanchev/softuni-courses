package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private Random random;

    public RandomArrayList (Random random) {
        this.random = random;
    }

    public T getRandomElement() {
        int rnd = random.nextInt(super.size());
        return super.get(rnd);
    }
}
