import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SoldierTest {
    private NowySzeregowy szeregowy;
    private NowyKapral kapral;


    @Before
    public void setUp() {
        szeregowy = new NowySzeregowy(1);
        kapral = new NowyKapral(1);
    }

    @Test
    public void testLevelUp() {
        szeregowy.levelUp();
        assertEquals("Kapral", szeregowy.rank);
        assertEquals(2, szeregowy.power_multiplier);

        kapral.levelUp();
        assertEquals("Kapitan", kapral.rank);
        assertEquals(3, kapral.power_multiplier);
    }

    @Test
    public void testIncreaseExperience() {
        szeregowy.increaseExperience(4);
        assertEquals("Kapral", szeregowy.rank);
        assertEquals(1, szeregowy.exp);

        kapral.increaseExperience(9);
        assertEquals("Kapitan", kapral.rank);
        assertEquals(1, kapral.exp);
    }

    @Test
    public void testGetPower() {
        assertEquals(1, szeregowy.getPower());
        assertEquals(2, kapral.getPower());
    }

    @Test
    public void testIsDead() {
        szeregowy.exp = 0;
        assertTrue(szeregowy.isDead());

        kapral.exp = 0;
        assertTrue(kapral.isDead());
    }

    @Test
    public void testGetRankValue() {
        assertEquals(1, szeregowy.getRankValue());
        assertEquals(2, kapral.getRankValue());
    }
}
