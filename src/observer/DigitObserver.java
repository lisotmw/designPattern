package observer;

public class DigitObserver implements Observer{

	@Override
	public void update(NumberGenerator generator) {
		System.out.println("DigitObserver: "+generator.getNum());
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			
		}
	}

}
