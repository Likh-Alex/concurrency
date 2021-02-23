package util;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UtilTest {
    public static int RANDOM_QUALIFIER = 3;
    public static Util util;

    @Before
    public void setUp() {
        util = new Util();
        List<Integer> list = util.getRandomList(RANDOM_QUALIFIER);
    }

    @Test
    public void createAndCheckRandomList_Ok() {
        List<Integer> expected = util.getRandomList(RANDOM_QUALIFIER);
        assertEquals(expected, util.getList());
    }
}
