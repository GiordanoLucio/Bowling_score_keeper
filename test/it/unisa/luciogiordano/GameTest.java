package it.unisa.luciogiordano;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unisa.luciogiordano.Frame;
import it.unisa.luciogiordano.Game;
import it.unisa.luciogiordano.InvalidInputException;

public class GameTest {
	ArrayList<Frame> listFrame = new ArrayList<Frame>();
	Game game;

	@Test
	public void testGameScore() throws InvalidInputException {
		listFrame.add(new Frame(1,5));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(4,4));
		listFrame.add(new Frame(5,3));
		listFrame.add(new Frame(3,3));
		listFrame.add(new Frame(4,5));
		listFrame.add(new Frame(8,1));
		listFrame.add(new Frame(2,6));
		game = new Game(listFrame);
		int score = game.getScore();
		assertEquals(81, score);
	}
	@Test
	public void testGameScoreWithStrike() throws InvalidInputException {
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(4,4));
		listFrame.add(new Frame(5,3));
		listFrame.add(new Frame(3,3));
		listFrame.add(new Frame(4,5));
		listFrame.add(new Frame(8,1));
		listFrame.add(new Frame(2,6));
		game = new Game(listFrame);
		assertEquals(game.getScore(), 94);
	}

	@Test
	public void testGameWithSpare() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(1,9));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(4,4));
		listFrame.add(new Frame(5,3));
		listFrame.add(new Frame(3,3));
		listFrame.add(new Frame(4,5));
		listFrame.add(new Frame(8,1));
		listFrame.add(new Frame(2,6));
		game = new Game(listFrame);
		assertEquals(game.getScore(), 88);
	}

	@Test
	public void testGameWithStrikeAndSpare() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(4,6));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(4,4));
		listFrame.add(new Frame(5,3));
		listFrame.add(new Frame(3,3));
		listFrame.add(new Frame(4,5));
		listFrame.add(new Frame(8,1));
		listFrame.add(new Frame(2,6));
		game = new Game(listFrame);
		assertEquals(game.getScore(), 103);
	}
	@Test
	public void testGameWithMultipleStrike() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(4,4));
		listFrame.add(new Frame(5,3));
		listFrame.add(new Frame(3,3));
		listFrame.add(new Frame(4,5));
		listFrame.add(new Frame(8,1));
		listFrame.add(new Frame(2,6));
		game = new Game(listFrame);
		assertEquals(game.getScore(), 112);
	}

	@Test
	public void testGameWithMultipleSpares() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(8,2));
		listFrame.add(new Frame(5,5));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(4,4));
		listFrame.add(new Frame(5,3));
		listFrame.add(new Frame(3,3));
		listFrame.add(new Frame(4,5));
		listFrame.add(new Frame(8,1));
		listFrame.add(new Frame(2,6));
		game = new Game(listFrame);
		assertEquals(game.getScore(), 98);
	}
	@Test
	public void testGameWithMultipleSparesLastIsSpare() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(1,5));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(4,4));
		listFrame.add(new Frame(5,3));
		listFrame.add(new Frame(3,3));
		listFrame.add(new Frame(4,5));
		listFrame.add(new Frame(8,1));
		listFrame.add(new Frame(2,8));
		game = new Game(listFrame, new Frame(7));
		assertEquals(game.getScore(), 90);
	}
	@Test
	public void testGameWithMultipleSparesLastIsStrike() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(1,5));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(4,4));
		listFrame.add(new Frame(5,3));
		listFrame.add(new Frame(3,3));
		listFrame.add(new Frame(4,5));
		listFrame.add(new Frame(8,1));
		listFrame.add(new Frame(10,0));
		game = new Game(listFrame, new Frame(7,2));
		assertEquals(game.getScore(), 92);
	}

	@Test
	public void testRealGame() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(6,3));
		listFrame.add(new Frame(7,1));
		listFrame.add(new Frame(8,2));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(6,2));
		listFrame.add(new Frame(7,3));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(8,0));
		listFrame.add(new Frame(7,3));
		game = new Game(listFrame, new Frame(10));
		assertEquals(game.getScore(), 135);
	}
	@Test
	public void testRealGame2() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(8,0));
		listFrame.add(new Frame(5,5));
		listFrame.add(new Frame(3,5));
		listFrame.add(new Frame(8,1));
		listFrame.add(new Frame(7,1));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(9,1));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(8,2));
		game = new Game(listFrame, new Frame(6));
		assertEquals(game.getScore(), 150);
	}


	@Test
	public void testGameWithMultipleSparesBonus() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(8,2));
		listFrame.add(new Frame(5,5));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(3,6));
		listFrame.add(new Frame(4,4));
		listFrame.add(new Frame(5,3));
		listFrame.add(new Frame(3,3));
		listFrame.add(new Frame(4,5));
		listFrame.add(new Frame(8,1));
		listFrame.add(new Frame(2,6));
		//the bonus will not be used because the 10th frame is not a strike
		game = new Game(listFrame, new Frame(10));
		assertEquals(game.getScore(), 98);
	}

	@Test
	public void testGameWithRealData() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(9,1));
		listFrame.add(new Frame(5,5));
		listFrame.add(new Frame(7,2));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(9,0));
		listFrame.add(new Frame(8,2));
		listFrame.add(new Frame(9,1));
		Frame frameBonus = new Frame(10);
		game = new Game(listFrame, frameBonus);
		assertEquals(game.getScore(), 187);
	}

	@Test
	public void testGameAlmostPerfectScore1() throws InvalidInputException{
		ArrayList<Frame> listFrame = new ArrayList<Frame>();
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		listFrame.add(new Frame(10,0));
		game = new Game(listFrame, new Frame(10), new Frame(10));
		assertEquals(game.getScore(), 300);
	}

}
