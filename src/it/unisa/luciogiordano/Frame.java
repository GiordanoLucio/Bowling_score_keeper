package it.unisa.luciogiordano;

public class Frame {
	private int first_throw, second_throw;
	private int total_score=0;

	public Frame(int first_throw, int second_throw) throws InvalidInputException {
		if(first_throw > 10 || second_throw > 10 || first_throw < 0 || second_throw < 0) {
			throw new InvalidInputException();
		}else {
			this.first_throw=first_throw;
			this.second_throw=second_throw;
			if(first_throw + second_throw > 10) {
				throw new InvalidInputException();
			}
		}}
	public Frame() throws InvalidInputException{
		
	}

	public Frame(int first_throw) throws InvalidInputException{
		this.first_throw = first_throw;
	}
	public int getFirst_throw() {
		return first_throw;
	}


	public int getSecond_throw() {
		return second_throw;
	}

	public int get_total_score() {
		this.total_score=first_throw + second_throw;
		return total_score;
	}

	public boolean isStrike() throws InvalidInputException {
		if(first_throw == 10) {
			if(second_throw == 0) {
				return true;
			}else {
				throw new InvalidInputException();
			}
		}else {
			return false;
		}
	}

	public boolean isSpare() throws InvalidInputException{
		if(first_throw != 10) {
			if (first_throw + second_throw == 10) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
