package it.unisa.luciogiordano;

import java.util.ArrayList;

public class Game {

	private int score = 0;
	ArrayList<Frame> frame = new ArrayList<Frame>();
	Frame frameBonus = new Frame();
	Frame frameBonus2 = new Frame();
	public Game(ArrayList<Frame> frame) throws InvalidInputException{
		this.frame = frame;
	}
	public Game(ArrayList<Frame> frame, Frame frameBonus) throws InvalidInputException{
		this.frame = frame;
		this.frameBonus = frameBonus;
	}
	public Game(ArrayList<Frame> frame, Frame frameBonus, Frame frameBonus2) throws InvalidInputException{
		this.frame = frame;
		this.frameBonus = frameBonus;
		this.frameBonus2 = frameBonus2;
	}
	

	public int getScore() throws InvalidInputException {
		frame.add(frameBonus);
		frame.add(frameBonus2);
		for(int i=0; i<10;i++) {
			Frame f = frame.get(i);
			score += f.get_total_score();
			if (f.isStrike()) {
				Frame fNext = frame.get(i+1);
				score += fNext.get_total_score();
				if(fNext.isStrike()) {
					score += frame.get(i+2).getFirst_throw();
				}
			}
			if(f.isSpare()) {
				score += frame.get(i+1).getFirst_throw();
			}
		}
		return score;
	}

}
