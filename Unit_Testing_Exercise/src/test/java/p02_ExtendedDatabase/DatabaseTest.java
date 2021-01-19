package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static Database database;

    @Before
    public void init() throws OperationNotSupportedException {
        database = new Database(new Person(1, "George"),
                   new Person(2, "Martin"),
                   new Person(3, "Lucas")
        );
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testArrayCapacityNotExactlySixteenIntegersShouldThrow() throws OperationNotSupportedException {
        if(database.getElements().length < 16 || database.getElements().length > 16) {
            throw new OperationNotSupportedException();
        }
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testArrayCapacityExactlySixteenIntegers() throws OperationNotSupportedException {
        Database database = new Database();
        assertEquals(16, database.getElements().length);
    }

    @Test
    public void testAddElementOnTheNextFreeCellShouldThrow() throws OperationNotSupportedException {
        Person value = new Person(4, "John");
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
        Person[] arr = { new Person(1, "George"),
                new Person(2, "Martin"),
                new Person(3, "Lucas")};

        assertArrayEquals(arr, database.getElements());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCheckIfUsernameIsNullShouldThrow() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCheckIfUsernameIsAlreadyTakenShouldThrow() throws OperationNotSupportedException {
        database.add(new Person(4, "George"));
        database.findByUsername("George");
    }

    @Test
    public void testFindByUserNameShouldWorkProperly() throws OperationNotSupportedException {
        Person expected = new Person(1, "George");
        Person actual = database.findByUsername("George");
        assertEquals(expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCheckIfIdIsAlreadyTakenShouldThrow() throws OperationNotSupportedException {
        database.add(new Person(1, "Ivan"));
        database.findById(1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCheckIfIdHasNoMatchShouldThrow() throws OperationNotSupportedException {
        database.findById(4);
    }

    @Test
    public void testFindByIdShouldWorkProperly() throws OperationNotSupportedException {
        Person expected = new Person(1, "George");
        Person actual = database.findById(1);
        assertEquals(expected, actual);
    }





}