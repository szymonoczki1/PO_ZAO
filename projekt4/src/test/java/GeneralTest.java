import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class GeneralTest {
    private General general1;
    private General general2;
    private Sekretarz sekretarz;

    @Before
    public void setUp() {
        sekretarz = new Sekretarz();
        general1 = new General(100, "General1", new ArrayList<Soldier>(), sekretarz);
        general2 = new General(100, "General2", new ArrayList<Soldier>(), sekretarz);
    }

    @Test
    public void testAddSoldier() {
        general1.addSoldier(new NowySzeregowy(1));
        assertEquals(1, general1.army.size());
    }

    @Test
    public void testRemoveSoldier() {
        NowySzeregowy soldier = new NowySzeregowy(1);
        general1.addSoldier(soldier);
        general1.removeSoldier(soldier);
        assertEquals(0, general1.army.size());
    }

    @Test
    public void testManewry() {
        general1.addSoldier(new NowySzeregowy(1));
        boolean result = general1.manewry(0);
        assertTrue(result);
        assertTrue(sekretarz.list.contains("Szeregowydostal +1 exp"));
    }

    @Test
    public void testGetArmyPower() {
        general1.addSoldier(new NowySzeregowy(1));
        general1.addSoldier(new NowyKapral(1));
        assertEquals(3, general1.getArmyPower());
    }

    @Test
    public void testChangeArmyExp() {
        general1.addSoldier(new NowySzeregowy(1));
        general1.addSoldier(new NowyKapral(1));
        general1.changeArmyExp(1);
        assertTrue(sekretarz.list.contains("Kapraldostal1exp"));
    }

    @Test
    public void testRemoveRandomSoldier() {
        general1.addSoldier(new NowySzeregowy(1));
        general1.addSoldier(new NowyKapral(1));
        general1.removeRandomSoldier();
        assertTrue(general1.army.size() == 1);
    }

    @Test
    public void testAtak() {
        general1.addSoldier(new NowySzeregowy(1));
        general2.addSoldier(new NowyKapral(1));
        general1.atak(general2);
        assertTrue(sekretarz.list.contains("General1zaatakowalGeneral2"));
    }

    @Test
    public void testAtakEffects() {
        general1.addSoldier(new NowySzeregowy(1));
        double initialGold = general1.gold;
        general1.atak(general2);
        double finalGold = general1.gold;

        assertTrue(finalGold > initialGold);
        assertTrue(general1.army.get(0).exp == 2);
    }


    @Test
    public void testBuySoldier() {
        boolean result = general1.buySoldier(1);
        assertTrue(result);
        assertEquals(1, general1.army.size());
    }

    @Test
    public void testBuySoldierOutOfGold() {
        general1.gold = 5;  // not enough to buy a soldier
        boolean result = general1.buySoldier(4);
        assertFalse(result);
    }
}
