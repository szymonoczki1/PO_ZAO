import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class WojnaTest {
    Wojna wojna;
    
    @Before
    public void setUp() {
        wojna = new Wojna();
    }

    @Test
    public void testGeneral1KupujeZolnierza() {
        wojna.General1KupujeZolnierza(1);
        assertEquals("General1 should have 1 soldier in the army.", 1, wojna.general1.army.size());
    }

    @Test
    public void testGeneral2KupujeZolnierza() {
        wojna.General2KupujeZolnierza(2);
        assertEquals("General2 should have 1 soldier in the army.", 1, wojna.general2.army.size());
    }

    @Test
    public void testGeneral1WypowiadaWojne() {
        wojna.General1KupujeZolnierza(3);
        wojna.General2KupujeZolnierza(2);
        wojna.General1WypowiadaWojne();
        assertTrue("General1 should have performed an attack.", wojna.sekretarz.list.contains("General1zaatakowalGeneral2"));
    }

    @Test
    public void testGeneral2WypowiadaWojne() {
        wojna.General1KupujeZolnierza(2);
        wojna.General2KupujeZolnierza(3);
        wojna.General2WypowiadaWojne();
        assertTrue("General2 should have performed an attack.", wojna.sekretarz.list.contains("General2zaatakowalGeneral1"));
    }

    @Test
    public void testGeneral1WykonujeManewry() {
        wojna.General1KupujeZolnierza(4);
        wojna.General1WykonujeManewry(0);
        assertTrue("General1 should have performed maneuvers.", wojna.sekretarz.list.contains("Majordostal +1 exp"));
    }

    @Test
    public void testGeneral2WykonujeManewry() {
        wojna.General2KupujeZolnierza(2);
        wojna.General2WykonujeManewry(0);
        assertTrue("General2 should have performed maneuvers.", wojna.sekretarz.list.contains("Kapraldostal +1 exp"));
    }

    @Test
    public void testSekretarz() {
        wojna.General1KupujeZolnierza(3);
        assertTrue("Sekretarz should print a list of actions.", wojna.sekretarz.list.contains("General1kupilKapitan"));
    }

    @Test
    public void testBuySoldierOutOfGold() {
        wojna.general1.gold = 10;
        wojna.General1KupujeZolnierza(4);
        assertTrue("General1 should be unable to buy a soldier if out of gold.", wojna.sekretarz.list.contains("General1probowal kupic zolnierza ale nie bylo go na to stac"));
    }
}
