package processing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import org.apache.commons.collections4.ListUtils;
import thread.SumCalculatorRecursiveTask;

public class SumListWithForkJoin {
    private static final int THREAD_COUNT = 10;
    private List<Integer> list;

    public SumListWithForkJoin(List<Integer> list) {
        this.list = list;
    }

    public int getListSummary() {
        List<List<Integer>> partitions = ListUtils.partition(list, list.size() / THREAD_COUNT);
        List<SumCalculatorRecursiveTask> recursiveThreads = addPartitions(partitions);
        Collection<SumCalculatorRecursiveTask> invokedThreads = ForkJoinTask
                .invokeAll(recursiveThreads);
        return getThreadsResult(invokedThreads);
    }

    private int getThreadsResult(Collection<SumCalculatorRecursiveTask> invokedThreads) {
        int summary = 0;
        for (SumCalculatorRecursiveTask task : invokedThreads) {
            summary += task.join();
        }
        return summary;
    }

    private List<SumCalculatorRecursiveTask> addPartitions(List<List<Integer>> partitions) {
        List<SumCalculatorRecursiveTask> recursiveThreads = new ArrayList<>();
        for (List<Integer> partition : partitions) {
            recursiveThreads.add(new SumCalculatorRecursiveTask(partition));
        }
        return recursiveThreads;
    }
}
