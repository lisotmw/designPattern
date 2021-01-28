package observer;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator{

	private int number;
	private Random r = new Random(47);
	
	@Override
	public int getNum() {
		return number;
	}

	@Override
	public void execute() {
		for(int i=0;i<20;i++) {
			number = r.nextInt(50);
			notifyObservers();
		}
	}
	
}
