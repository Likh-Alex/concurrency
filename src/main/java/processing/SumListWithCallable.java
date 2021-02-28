package processing;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;
import thread.SumCalculatorCallable;

public class SumListWithCallable {
    private static final int THREAD_COUNT = 10;
    private final List<Integer> list;

    public SumListWithCallable(List<Integer> list) {
        this.list = list;
    }

    public int getListSummary() {
        List<List<Integer>> partitions = ListUtils.partition(list,list.size() / THREAD_COUNT);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<SumCalculatorCallable> sumCalculatorCallables = partitions.stream()
                .map(SumCalculatorCallable::new)
                .collect(Collectors.toList());
        try {
            executorService.invokeAll(sumCalculatorCallables);
        } catch (InterruptedException e) {
            throw new RuntimeException("Can not invoke all threads: ", e);
        }
        int summary = getThreadsResult(executorService, sumCalculatorCallables);
        executorService.shutdown();
        return summary;
    }

    private int getThreadsResult(ExecutorService executorService,
                                 List<SumCalculatorCallable> sumCalculatorCallables) {
        int summary = 0;
        for (SumCalculatorCallable thread: sumCalculatorCallables) {
            try {
                summary += executorService.submit(thread).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Can not obtain result from the thread: " + thread, e);
            }
        }
        return summary;
    }
}
