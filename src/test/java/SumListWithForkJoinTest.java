import org.junit.Before;
import org.junit.Test;
import processing.SumListWithForkJoin;
import util.ListOfNumbersGenerator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumListWithForkJoinTest {
    private static final int LIST_SIZE = 1_000_000;
    private static final int RANDOM_QUALIFIER = 3;
    private SumListWithForkJoin joinFormSum;
    private ListOfNumbersGenerator util;
    private List<Integer> list;

    public int getCurrentSum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    @Before
    public void setUp() {
        util = new ListOfNumbersGenerator();
        list = util.getRandomList(RANDOM_QUALIFIER, LIST_SIZE);
        joinFormSum = new SumListWithForkJoin(list);
    }

    @Test
    public void getSummary_Ok() {
        int actual = joinFormSum.getListSummary();
        int expected = getCurrentSum(list);
        assertEquals(expected, actual);
    }
}
