package computers;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
public class ComputerTest {

    private static Computer pc;

    @Before
    public void init() {
        pc = new Computer("HP");
        pc.addPart(new Part("RAM", 3));
        pc.addPart(new Part("CPU", 3));
        pc.addPart(new Part("Cooler", 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfNameIsEmptyString() {
        pc = new Computer("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfNameIsNull() {
        pc = new Computer(null);
    }
    @Test
    public void testIfConstructorWorkProperly() {
        pc = new Computer("HP");
    }
    @Test
    public void testIfGetNameIsWorkingCorectly() {
        Computer computer = new Computer("HP");
        String actual = computer.getName();
        assertEquals("HP", actual);
    }
    @Test
    public void testIfGetNameIsNotWorkingCorectly() {
        Computer computer = new Computer("HP");
        String actual = computer.getName();
        assertNotEquals("MSI", actual);
    }

    @Test
    public void testIfListIsNotModifiable() {
        Computer computer = new Computer("HP");
        Part ram = new Part("RAM", 120.99);
        computer.addPart(ram);

        List<Part> expected = computer.getParts();
        expected.get(0).setPrice(15.99);
        List<Part> actual = computer.getParts();
        assertEquals(expected.get(0).getPrice(), actual.get(0).getPrice(), 0.0);
    }
    @Test
    public void testIfListIsModifiable() {
        Computer computer = new Computer("HP");
        Part ram = new Part("RAM", 120.99);
        computer.addPart(ram);

        Computer pc = new Computer("HP");
        Part cpu = new Part("CPU", 121.99);
        pc.addPart(cpu);

        assertNotEquals(computer.getPart("RAM").getPrice(), pc.getPart("CPU").getPrice(), 0.0);
    }
    @Test
    public void testIfTotalPriceIsCorrect() {
        double expected = 9.0;
        double actual = pc.getTotalPrice();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testIfTotalPriceIsNotCorrect() {
        double expected = 10.0;
        double actual = pc.getTotalPrice();

        assertNotEquals(expected, actual, 0.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfAddPartIsNotNull() {
        pc.addPart(null);
    }
    @Test
    public void testIfAddPartIsWorkingCorrectly() {
        Part part = new Part("Monitor", 120);
        pc.addPart(part);
        boolean contains = pc.getParts().contains(part);
        assertTrue(contains);
    }
    @Test
    public void testIfPartIsRemovedCorrectly() {
        Part part = new Part("Monitor", 120);
        pc.addPart(part);
        boolean isRemoved = pc.removePart(part);

        assertTrue(isRemoved);
    }
    @Test
    public void testIfPartIsNotRemovedCorrectly() {
        Part part = new Part("Monitor", 120);
        boolean isRemoved = pc.removePart(part);

        assertFalse(isRemoved);
    }
    @Test
    public void testIfPartNameIsNotFoundIsEqualsToNull() {
        Part actual = pc.getPart("Monitor");
        assertNull(actual);
    }
    @Test
    public void testIfPartNameIsFound() {
        Part actual = pc.getPart("RAM");
        assertNotNull(actual);
    }


}