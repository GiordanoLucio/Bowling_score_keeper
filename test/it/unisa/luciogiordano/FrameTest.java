package it.unisa.luciogiordano;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void testFirstThrow() throws InvalidInputException {
		Frame frame = new Frame(2,4);
		assertEquals(frame.getFirst_throw(), 2);
	}
	@Test(expected= InvalidInputException.class)
	public void testFirstThrowExceptionMoreThan10() throws InvalidInputException{
		new Frame(15);
	}
	@Test(expected= InvalidInputException.class)
	public void testFirstThrowExceptionLessThan0() throws InvalidInputException{
		new Frame(-1);
	}
	
	@Test
	public void testSecondThrow() throws InvalidInputException {
		Frame frame = new Frame(2,4);
		assertEquals(frame.getSecond_throw(), 4);
	}
	@Test
	public void testTotalScore() throws InvalidInputException {
		Frame frame = new Frame(3,4);
		assertEquals(frame.get_total_score(), 7);
	}
	@Test
	public void testTotalScore2() throws InvalidInputException{
		Frame frame = new Frame(2,6);
		assertEquals(frame.get_total_score(), 8);
	}
	@Test
	public void testTotalScore3() throws InvalidInputException{
		Frame frame = new Frame(0,9);
		assertEquals(frame.get_total_score(), 9);
	}
	
	@Test(expected = InvalidInputException.class)
	public void testScoreGreaterThan10() throws InvalidInputException{
		new Frame(2,9);
	}	
	@Test(expected = InvalidInputException.class)
	public void testSecondThrowGreaterThan10() throws InvalidInputException{
		new Frame(2,11);
	}	
	@Test(expected = InvalidInputException.class)
	public void testFirstThrowGreaterThan10() throws InvalidInputException{
		new Frame(11,1);
	}	
	@Test(expected = InvalidInputException.class)
	public void testFirstThrowSmallerThan0() throws InvalidInputException{
		new Frame(-1,9);
	}
	@Test(expected = InvalidInputException.class)
	public void testSecondThrowSmallerThan0() throws InvalidInputException{
		new Frame(2,-1);
	}
	@Test(expected=InvalidInputException.class)
	public void testGameScoreWithWrongStrike() throws InvalidInputException {
		new Frame(10,1);
	}
	@Test
	public void isSpareWithZeroTen() throws InvalidInputException{
	Frame frame = new Frame(0, 10);
	assertTrue(frame.isSpare());
	}
	@Test
	public void testSpareFirstIsGreater() throws InvalidInputException{
		Frame frame = new Frame(9,1);
		boolean spare = frame.isSpare();
		assertTrue(spare);
	}
	@Test
	public void testSpareMiddleValues() throws InvalidInputException{
		Frame frame = new Frame(5,5);
		boolean spare = frame.isSpare();
		assertTrue(spare);
	}
	@Test
	public void testSpareSecondIsGreater() throws InvalidInputException{
		Frame frame = new Frame(1, 9);
		boolean spare = frame.isSpare();
		assertTrue(spare);
	}
	@Test
	public void testNotSpare() throws InvalidInputException{
		Frame frame = new Frame(1,2);
		boolean spare = frame.isSpare();
		assertFalse(spare);
	}
	@Test
	public void testNotSpareButStrike() throws InvalidInputException{
		Frame frame = new Frame(10, 0);
		boolean spare = frame.isSpare();
		assertFalse(spare);
		assertTrue(frame.isStrike());
	}

	@Test(expected=InvalidInputException.class)
	public void testCrash() throws InvalidInputException{
		new Frame(10,1);
	}

}
