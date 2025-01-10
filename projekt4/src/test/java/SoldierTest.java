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
        // Level up Szeregowy (Rank 1 -> Kapral)
        szeregowy.levelUp();
        assertEquals("Rank should be Kapral.", "Kapral", szeregowy.rank);
        assertEquals("Power multiplier should be 2.", 2, szeregowy.power_multiplier);

        // Level up Kapral (Rank 2 -> Kapitan)
        kapral.levelUp();
        assertEquals("Rank should be Kapitan.", "Kapitan", kapral.rank);
        assertEquals("Power multiplier should be 3.", 3, kapral.power_multiplier);
    }

    @Test
    public void testIncreaseExperience() {
        szeregowy.increaseExperience(4); // Should level up
        assertEquals("Szeregowy should level up to Kapral.", "Kapral", szeregowy.rank);
        assertEquals("Experience should be reset to 1.", 1, szeregowy.exp);

        kapral.increaseExperience(9); // Should level up
        assertEquals("Kapral should level up to Kapitan.", "Kapitan", kapral.rank);
        assertEquals("Experience should be reset to 1.", 1, kapral.exp);
    }

    @Test
    public void testGetPower() {
        assertEquals("Szeregowy power should be 10.", 1, szeregowy.getPower());
        assertEquals("Kapral power should be 20.", 2, kapral.getPower());
    }

    @Test
    public void testIsDead() {
        szeregowy.exp = 0;
        assertTrue("Szeregowy should be dead.", szeregowy.isDead());

        kapral.exp = 0;
        assertTrue("Kapral should be dead.", kapral.isDead());
    }

    @Test
    public void testGetRankValue() {
        assertEquals("Szeregowy rank value should be 1.", 1, szeregowy.getRankValue());
        assertEquals("Kapral rank value should be 2.", 2, kapral.getRankValue());
    }
}
