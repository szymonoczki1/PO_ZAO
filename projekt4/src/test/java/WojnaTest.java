import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class WojnaTest {
    Wojna wojna;
    
    @Before
    public void setUp() {
        wojna = new Wojna();
    }

    @Test
    public void testGeneral1SaveStatus() {
        //Soldier soldier = new NowyKapitan(0);
        //wojna.general1.army.add(soldier);
        
        wojna.General1SaveStatus();

        String filename = "General1_status.txt";
        File file = new File(filename);
        assertTrue(file.exists());

        file.delete();
    }

    @Test
    public void testGeneral1LoadStatus() throws IOException {

        String filename = "General1_status.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("General1\n"); //name
            writer.write("200.0\n"); //gold
            writer.write("2\n"); //amount of soldiers
            writer.write("1 4\n"); //rank 1 exp 4
            writer.write("3 10\n"); //rank 3 exp 10
        }

        wojna.General1LoadStatus();

        assertEquals("General1", wojna.general1.name);
        assertEquals(200.0, wojna.general1.gold, 0.001);
        assertEquals(2, wojna.general1.army.size());

        Soldier soldier1 = wojna.general1.army.get(0);
        assertEquals(1, soldier1.power_multiplier);
        assertEquals(4, soldier1.exp);

        Soldier soldier2 = wojna.general1.army.get(1);
        assertEquals(3, soldier2.power_multiplier);
        assertEquals(10, soldier2.exp);

        new File(filename).delete();
    }

    @Test
    public void testGeneral1KupujeZolnierza() {
        wojna.General1KupujeZolnierza(1);
        assertEquals(1, wojna.general1.army.size());
    }

    @Test
    public void testGeneral2KupujeZolnierza() {
        wojna.General2KupujeZolnierza(2);
        assertEquals(1, wojna.general2.army.size());
    }

    @Test
    public void testGeneral1WypowiadaWojne() {
        wojna.General1KupujeZolnierza(3);
        wojna.General2KupujeZolnierza(2);
        wojna.General1WypowiadaWojne();
        assertTrue(wojna.sekretarz.list.contains("General1zaatakowalGeneral2"));
    }

    @Test
    public void testGeneral2WypowiadaWojne() {
        wojna.General1KupujeZolnierza(2);
        wojna.General2KupujeZolnierza(3);
        wojna.General2WypowiadaWojne();
        assertTrue(wojna.sekretarz.list.contains("General2zaatakowalGeneral1"));
    }

    @Test
    public void testGeneral1WykonujeManewry() {
        wojna.General1KupujeZolnierza(4);
        wojna.General1WykonujeManewry(0);
        assertTrue(wojna.sekretarz.list.contains("Majordostal +1 exp"));
    }

    @Test
    public void testGeneral2WykonujeManewry() {
        wojna.General2KupujeZolnierza(2);
        wojna.General2WykonujeManewry(0);
        assertTrue(wojna.sekretarz.list.contains("Kapraldostal +1 exp"));
    }

    @Test
    public void testSekretarz() {
        wojna.General1KupujeZolnierza(3);
        assertTrue(wojna.sekretarz.list.contains("General1kupilKapitan"));
    }

    @Test
    public void testBuySoldierOutOfGold() {
        wojna.general1.gold = 10;
        wojna.General1KupujeZolnierza(4);
        assertTrue(wojna.sekretarz.list.contains("General1probowal kupic zolnierza ale nie bylo go na to stac"));
    }
}
