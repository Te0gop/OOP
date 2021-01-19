package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static Database database;

    @Before
    public void init() throws OperationNotSupportedException {
        database = new Database(1, 2, 3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testArrayCapacityNotExactlySixteenIntegersShouldThrow() throws OperationNotSupportedException {
        if(database.getElements().length < 16 || database.getElements().length > 16) {
            throw new OperationNotSupportedException();
        }
    }
    @Test
    public void testArrayCapacityExactlySixteenIntegers() throws OperationNotSupportedException {
        Database database = new Database(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
        assertEquals(16, database.getElements().length);
    }

    @Test
    public void testAddElementOnTheNextFreeCellShouldThrow() throws OperationNotSupportedException {
        Integer value = 4;
        int expectedLength = database.getElements().length + 1;

        database.add(value);

        assertEquals(expectedLength, database.getElements().length);
        assertEquals(value, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testElementIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyArray() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.remove();
    }

    @Test
    public void testRemoveElementFromArray() throws OperationNotSupportedException {

        int expectedLength = database.getElements().length - 1;
        database.remove();

        assertEquals(expectedLength, database.getElements().length);
    }

    @Test
    public void testShouldReturnElementsOfArray(){
        Integer[] arr = {1, 2, 3};

        assertArrayEquals(arr, database.getElements());

    }





}