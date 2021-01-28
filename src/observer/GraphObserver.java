package observer;

public class GraphObserver implements Observer {

	@Override
	public void update(NumberGenerator generator) {
		System.out.print("GraphObserver:");
		int count = generator.getNum();
		for(int i=0;i<count;i++) {
			System.out.print('*');
		}
		System.out.println();
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {}
	}

}
