package thread;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskThread extends RecursiveTask<Integer> {
    private List<Integer> list;

    public RecursiveTaskThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        return list.stream().reduce(0, Integer::sum);
    }
}
