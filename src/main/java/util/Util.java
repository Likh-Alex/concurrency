package util;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private static final int DESIRED_SIZE = 1_000_000;
    private final List<Integer> list = new ArrayList<>();

    public List<Integer> getList() {
        return list;
    }

    public List<Integer> getRandomList(int number) {
        while (list.size() < DESIRED_SIZE) {
            list.add((int) (Math.random() * number));
        }
        return list;
    }

    public int getCurrentSum() {
        return list.stream().reduce(0, Integer::sum);
    }
}
