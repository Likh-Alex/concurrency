import org.junit.Before;
import org.junit.Test;
import processing.SumListWithCallable;
import util.Util;
import java.util.List;

import static org.junit.Assert.*;

public class SumListWithCallableTest {
    private static final int RANDOM_QUALIFIER = 3;
    private static SumListWithCallable callableSum;
    private static Util util;

    @Before
    public void setUp() {
        util = new Util();
        List<Integer> list = util.getRandomList(RANDOM_QUALIFIER);
        callableSum = new SumListWithCallable(list);
    }

    @Test
    public void getSummary_Ok() {
        int actual = callableSum.getListSummary();
        int expected = util.getCurrentSum();
        assertEquals(expected, actual);
    }
}