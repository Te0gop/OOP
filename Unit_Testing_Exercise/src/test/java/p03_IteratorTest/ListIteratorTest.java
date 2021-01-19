package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    ListIterator listIterator;

    @Before
    public void init() throws OperationNotSupportedException {
        listIterator = new ListIterator( "George", "Martin", "John");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorIfNameIsNullShouldThrow() throws OperationNotSupportedException {
        listIterator = new ListIterator( null);
    }
    @Test
    public void testConstructorShouldWorkProperly() {
        ListIterator list = listIterator;
    }
    @Test
    public void testIfCanMoveToNextPosition() {
        assertTrue(listIterator.move());
    }
    @Test
    public void testIfCantMoveFurther() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        assertFalse(listIterator.move());
    }
    @Test
    public void testIfThereIsNoNextPosition() {
        listIterator.move();
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }
    @Test
    public void testHasNextPositionShouldWorkProperly() {
        listIterator.move();
        assertTrue(listIterator.hasNext());
    }
    @Test(expected = IllegalStateException.class)
    public void testIteratorIsEmptyShouldThrow() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();
        iterator.print();
    }
    @Test
    public void testIteratorPrintShouldWorkProperly() {
        String expected = "George";
        String actual = listIterator.print();
        assertEquals(expected, actual);
    }
    @Test
    public void testIfIteratorHasNextIndex() throws OperationNotSupportedException {
        ListIterator list = new ListIterator("George");
        assertFalse(list.hasNext());
    }
    @Test
    public void testIfIteratorHasNextIndexShouldWorkProperly() {
        assertTrue(listIterator.hasNext());
    }




}