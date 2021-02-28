import org.junit.Before;
import org.junit.Test;
import processing.SumListWithCallable;
import util.ListOfNumbersGenerator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumListWithCallableTest {
    private static final int LIST_SIZE = 1_000_000;
    private static final int RANDOM_QUALIFIER = 3;
    private SumListWithCallable callableSum;
    private ListOfNumbersGenerator util;
    private List<Integer> list;

    public int getCurrentSum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    @Before
    public void setUp() {
        util = new ListOfNumbersGenerator();
        list = util.getRandomList(RANDOM_QUALIFIER, LIST_SIZE);
        callableSum = new SumListWithCallable(list);
    }

    @Test
    public void getSummary_Ok() {
        int actual = callableSum.getListSummary();
        int expected = getCurrentSum(list);
        assertEquals(expected, actual);
    }
}
