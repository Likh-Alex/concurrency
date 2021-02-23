package processing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import org.apache.commons.collections4.ListUtils;
import thread.RecursiveTaskThread;

public class SumListWithForkJoin {
    private static final int THREAD_COUNT = 10;
    private List<Integer> list;

    public SumListWithForkJoin(List<Integer> list) {
        this.list = list;
    }

    public int getListSummary() {
        List<List<Integer>> partitions = ListUtils.partition(list, list.size() / THREAD_COUNT);
        List<RecursiveTaskThread> recursiveThreads = addPartitions(partitions);
        Collection<RecursiveTaskThread> invokedThreads = ForkJoinTask.invokeAll(recursiveThreads);
        return getThreadsResult(invokedThreads);
    }

    private int getThreadsResult(Collection<RecursiveTaskThread> invokedThreads) {
        int summary = 0;
        for (RecursiveTaskThread task : invokedThreads) {
            summary += task.join();
        }
        return summary;
    }

    private List<RecursiveTaskThread> addPartitions(List<List<Integer>> partitions) {
        List<RecursiveTaskThread> recursiveThreads = new ArrayList<>();
        for (List<Integer> partition : partitions) {
            recursiveThreads.add(new RecursiveTaskThread(partition));
        }
        return recursiveThreads;
    }
}
