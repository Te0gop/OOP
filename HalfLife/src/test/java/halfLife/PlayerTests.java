package halfLife;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
public class PlayerTests {

    private static Player player;
    private static Gun gun;

    @Before
    public void init() {
        player = new Player("George", 50);
        gun = new Gun("Pistol", 8);
    }


    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullForName() {
        Player player = new Player(null, 50);
    }
    @Test(expected = NullPointerException.class)
    public void testConstructorWithEmptyString() {
        Player player = new Player("", 50);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeHealth() {
        Player player = new Player("George", -50);
    }
    @Test
    public void testConstructorShouldWorkProperly() {
        Player p = player;
    }

    @Test
    public void testGetGunsIsNotModifiableList() {
        Player player = new Player("George", 50);
        List<Gun> guns = new ArrayList<>(){{add(gun);}};

        boolean unmodifiableList = Collections.unmodifiableList(guns).getClass().isInstance(player.getGuns());

        assertTrue(unmodifiableList);
    }
    @Test
    public void testGetGunsIsModifiableList() {
        List<Gun> guns = new ArrayList<>(){{add(gun);}};
        boolean unmodifiableList = guns.getClass().isInstance(player.getGuns());

        assertFalse(unmodifiableList);
    }
    @Test(expected = IllegalStateException.class)
    public void testIfHealthIsBellowZeroWhenTakeDamage() {
        player.takeDamage(50);
        player.takeDamage(50);
    }
    @Test
    public void testIfTakeDamageWorksProperly() {
        player.takeDamage(10);
        Player newPlayer = new Player("Martin", 40);
        int expected = player.getHealth();
        int actual = newPlayer.getHealth();
        assertEquals(expected, actual);
    }
    @Test(expected = NullPointerException.class)
    public void testIfNameOfGunIsNullWhenIsAddToList() {
        player.addGun(null);
    }
    @Test
    public void testIfGunIsAddedToListProperly() {
        player.addGun(new Gun("Rifle", 6));
        player.addGun(gun);
        int actual = player.getGuns().size();
        assertEquals(2, actual);
    }
    @Test
    public void testIfGunIsRemovedFromListShouldWork() {
        player.addGun(gun);
        player.removeGun(gun);
        assertEquals(0, player.getGuns().size());
    }
    @Test
    public void testIfGunIsNotRemovedFromList() {
        player.addGun(gun);
        Gun rifle = new Gun("Rifle", 6);
        player.removeGun(rifle);
        assertNotEquals(0, player.getGuns().size());
    }
    @Test
    public void testIfGunIsFoundByName() {
        player.addGun(gun);
        player.addGun(new Gun("Rifle", 6));
        String gunName = "Rifle";

        Gun actual = player.getGun(gunName);

        assertNotNull(actual);
    }
    @Test
    public void testListReturnsNullNameIsNotFound() {
        player.addGun(gun);
        player.addGun(new Gun("Rifle", 6));
        String gunName = "Knife";

        Gun actual = player.getGun(gunName);

        assertNull(actual);
    }
}
