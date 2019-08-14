import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int[][] input;
    private List<Integer> expected;
    private Solution soln = new Solution1();

    public SolutionTest(int[][] input, List<Integer> output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                }, Arrays.asList(
                        1,2,3,6,9,8,7,4,5
                )},
                {new int[][]{
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}
                }, Arrays.asList(
                        1,2,3,4,8,12,11,10,9,5,6,7
                )},
                {new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9},
                        {10,11,12}
                }, Arrays.asList(
                        1,2,3,6,9,12,11,10,7,4,5,8
                )},
                {new int[][]{
                        {7},
                        {9},
                        {6}
                }, Arrays.asList(
                        7,9,6
                )},
        });
    }

    @Test
    public void testSpiral() {
        assertEquals(expected, soln.spiralMatrix(input));
    }

}