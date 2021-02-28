import java.util.List;
import processing.SumListWithCallable;
import processing.SumListWithForkJoin;
import util.ListOfNumbersGenerator;

public class Main {
    private static final int DESIRED_SIZE = 1_000_000;

    public static void main(String[] args) {
        List<Integer> list = new ListOfNumbersGenerator().getRandomList(3, DESIRED_SIZE);
        SumListWithCallable callableSum = new SumListWithCallable(list);
        System.out.println(callableSum.getListSummary());
        SumListWithForkJoin forkSum = new SumListWithForkJoin(list);
        System.out.println(forkSum.getListSummary());
    }
}
