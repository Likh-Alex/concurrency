package util;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListOfNumbersGeneratorTest {
    private static final int DESIRED_SIZE = 1_000_000;
    public int RANDOM_QUALIFIER = 3;
    public ListOfNumbersGenerator util;

    @Before
    public void setUp() {
        util = new ListOfNumbersGenerator();
        List<Integer> list = util.getRandomList(RANDOM_QUALIFIER, DESIRED_SIZE);
    }

    @Test
    public void createAndCheckRandomList_Ok() {
        List<Integer> expected = util.getRandomList(RANDOM_QUALIFIER, DESIRED_SIZE);
        assertEquals(expected, util.getList());
    }
}
