package util;

import java.util.ArrayList;
import java.util.List;

public class ListOfNumbersGenerator {
    private final List<Integer> list = new ArrayList<>();

    public List<Integer> getList() {
        return list;
    }

    public List<Integer> getRandomList(int number, int size) {
        while (list.size() < size) {
            list.add((int) (Math.random() * number));
        }
        return list;
    }
}
