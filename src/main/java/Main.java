import java.util.List;
import processing.SumListWithCallable;
import processing.SumListWithForkJoin;
import util.Util;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new Util().getRandomList(3);
        SumListWithCallable callableSum = new SumListWithCallable(list);
        System.out.println(callableSum.getListSummary());
        SumListWithForkJoin forkSum = new SumListWithForkJoin(list);
        System.out.println(forkSum.getListSummary());
    }
}
