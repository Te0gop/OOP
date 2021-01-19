package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testCorrectSort() {
        int[] actual = {1, 6, 4, 5, 7};
        int[] expected = {1, 4, 5, 6, 7};

        Bubble.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testIncorrectSort() {
        int[] actual = {1, 6, 4, 5, 7};
        int[] expected = {1, 5, 4, 7, 6};

        Bubble.sort(actual);
        assertNotEquals(expected, actual);
    }

}