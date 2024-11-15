import org.junit.*;
import static org.junit.Assert.*;


public class RPNCalcTest {
    @Test
    public void testTransformInput() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("3 5 +");
        assertArrayEquals(new String[]{"3", "5", "+"}, calc.sequence);
    }

    @Test
    public void testIsRPNSequenceValid_Valid() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("3 5 +");
        assertTrue(calc.isRPNSequenceValid());
    }

    @Test
    public void testIsRPNSequenceValid_TooShort() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("3 +");
        assertFalse(calc.isRPNSequenceValid());
    }

    @Test
    public void testIsRPNSequenceValid_WrongOperator() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("3 5 !");
        assertFalse(calc.isRPNSequenceValid());
    }

    @Test
    public void testIsRPNSequenceValid_emptyStackOnAddition() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("+ 5 3");
        assertFalse(calc.isRPNSequenceValid());
    }

    @Test
    public void testCalculateFromStack_Addition() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("3 5 +");
        calc.calculateFromStack();
        assertEquals("8.00", calc.getResult());
    }

    @Test
    public void testCalculateFromStack_Subtraction() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("10 3 -");
        calc.calculateFromStack();
        assertEquals("7.00", calc.getResult());
    }

    @Test
    public void testCalculateFromStack_Multiplication() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("4 5 *");
        calc.calculateFromStack();
        assertEquals("20.00", calc.getResult());
    }

    @Test
    public void testCalculateFromStack_Division() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("15 3 /");
        calc.calculateFromStack();
        assertEquals("5.00", calc.getResult());
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculateFromStack_DivisionByZero() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("4 0 /");
        calc.calculateFromStack();
    }

    @Test(expected = IllegalStateException.class)
    public void testGetResult_2NumbersOnStack() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("3 5 + 2");
        calc.calculateFromStack();
        calc.getResult();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateFromStack_WrongOperator() {
        RPNCalc calc = new RPNCalc();
        calc.transformInput("5 3 ?");
        calc.calculateFromStack();
    }
}
