package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    public static CustomLinkedList<String> linkedList;

    @Before
    public void init() {
        linkedList = new CustomLinkedList<>();
        linkedList.add("George");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowException() {
        linkedList.get(1);
    }

    @Test
    public void testGetShouldWorkProperly() {
        String expected = "George";
        assertEquals(expected, linkedList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementToInvalidIndexShouldThrow() {
        linkedList.set(1, "Martin");
    }

    @Test
    public void testSetElementToValidIndex() {
        String expected = "Martin";
        linkedList.set(0, expected);
        String actual = linkedList.get(0);

        assertEquals(expected, actual);
    }
    @Test
    public void testAddIfListIsEmpty() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Martin");
        assertEquals("Martin", customLinkedList.get(0));
    }

    @Test
    public void testAddIfListIsNotEmpty() {
        linkedList.add("Martin");
        assertEquals(1, linkedList.indexOf("Martin"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtNotExistingIndexShouldThrow() {
        linkedList.removeAt(1);
    }
    @Test
    public void testRemoveAddShouldWorkProperly() {
        linkedList.add("Martin");
        assertEquals("Martin", linkedList.removeAt(1));
    }



}