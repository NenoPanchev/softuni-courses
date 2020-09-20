package randomArrayList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> list = new RandomArrayList(new Random());
        list.add(5);
        list.add(3);
        list.add(-1);
        list.add(4);
        System.out.println(list.getRandomElement());
    }
}
