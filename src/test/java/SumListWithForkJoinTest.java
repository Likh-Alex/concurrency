import org.junit.Before;
import org.junit.Test;
import processing.SumListWithForkJoin;
import util.Util;
import java.util.List;

import static org.junit.Assert.*;

public class SumListWithForkJoinTest {
    private static final int RANDOM_QUALIFIER = 3;
    private static SumListWithForkJoin joinFormSum;
    private static Util util;

    @Before
    public void setUp() {
        util = new Util();
        List<Integer> list = util.getRandomList(RANDOM_QUALIFIER);
        joinFormSum = new SumListWithForkJoin(list);
    }

    @Test
    public void getSummary_Ok() {
        int actual = joinFormSum.getListSummary();
        int expected = util.getCurrentSum();
        assertEquals(expected, actual);
    }
}