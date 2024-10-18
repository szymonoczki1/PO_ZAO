package kalkulator;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	@Test
	public void testAddOne(){
		// Arrange
		// sut = System Under Test
		Calculator sut = new Calculator();
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState(), 0.0001);
	}

	@Test
	public void testMultOneByTwo(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState(), 0.0001);
	}

	@Test
	public void testAddNegativeTwo(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.add(-2);
		assertEquals("1+(-2) = -1", -1, sut.getState(), 0.0001);
	}

	@Test
	public void testMultByZero(){
		Calculator sut = new Calculator();
		sut.setState(2);
		sut.mult(0);
		assertEquals("2*0 = 0", 0, sut.getState(), 0.0001);
	}

	@Test
	public void testMultByNegative(){
		Calculator sut = new Calculator();
		sut.setState(-2);
		sut.mult(-1);
		assertEquals("-2*-1 = 2", 2, sut.getState(), 0.0001);
	}

	@Test
	public void testAddZero(){
		Calculator sut = new Calculator();
		sut.setState(2);
		sut.add(0);
		assertEquals("2+0 = 0", 2, sut.getState(), 0.0001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivZero(){
		Calculator sut = new Calculator();
		sut.setState(2);
		sut.div(0);
	}

	@Test
	public void testDivThreeByTwo(){
		Calculator sut = new Calculator();
		sut.setState(3);
		sut.div(2);
		assertEquals("3/2 = 1.5", 1.5, sut.getState(), 0.0001);
	}

	@Test
	public void testSubThreeFromNegTen(){
		Calculator sut = new Calculator();
		sut.setState(-10);
		sut.sub(3);
		assertEquals("-10-3 = -13", -13, sut.getState(), 0.0001);
	}

	@Test
	public void testSetGetMemory(){
		Calculator sut = new Calculator();
		sut.setState(50);
		sut.saveInMemory();
		assertEquals(50, sut.getMemory(), 0.0001);
	}

	@Test
	public void testClearMemory(){
		Calculator sut = new Calculator();
		sut.setState(50);
		sut.saveInMemory();
		sut.clearMemory();
		assertEquals(0, sut.getMemory(), 0.0001);
	}

	@Test
	public void testAddFromMem(){
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.saveInMemory();
		sut.setState(3);
		sut.addMem();
		assertEquals("3+5 = 8", 8, sut.getState(), 0.0001);
	}

	@Test
	public void testSubFromMem(){
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.saveInMemory();
		sut.setState(3);
		sut.subMem();
		assertEquals("3-5 = -2", -2, sut.getState(), 0.0001);
	}

	@Test
	public void testMultFromMem(){
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.saveInMemory();
		sut.setState(3);
		sut.multMem();
		assertEquals("3*5 = 15", 15, sut.getState(), 0.0001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivByZeroFromMem(){
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.divMem();
	}

	@Test
	public void testDivByTwoFromMem(){
		Calculator sut = new Calculator();
		sut.setState(2);
		sut.saveInMemory();
		sut.setState(5);
		sut.divMem();
		assertEquals("5/2 = 2.5", 2.5, sut.getState(), 0.0001);
	}
}
