package processing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.collections4.ListUtils;
import thread.CallableThread;

public class SumListWithCallable {
    private static final int THREAD_COUNT = 10;
    private final List<Integer> list;

    public SumListWithCallable(List<Integer> list) {
        this.list = list;
    }

    public int getListSummary() {
        List<List<Integer>> partitions = ListUtils.partition(list,list.size() / THREAD_COUNT);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<CallableThread> callableThreads = new ArrayList<>();
        addPartitionsToThread(partitions, callableThreads);
        try {
            executorService.invokeAll(callableThreads);
        } catch (InterruptedException e) {
            throw new RuntimeException("Can not invoke all threads: ", e);
        }
        int summary = getThreadsResult(executorService, callableThreads);
        executorService.shutdown();
        return summary;
    }

    private void addPartitionsToThread(List<List<Integer>> partitions,
                                       List<CallableThread> callableThreads) {
        for (List<Integer> partition : partitions) {
            callableThreads.add(new CallableThread(partition));
        }
    }

    private int getThreadsResult(ExecutorService executorService,
                                 List<CallableThread> callableThreads) {
        int summary = 0;
        for (CallableThread thread: callableThreads) {
            try {
                summary += executorService.submit(thread).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Can not obtain result from the thread: " + thread, e);
            }
        }
        return summary;
    }
}
