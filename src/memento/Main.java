package memento;

import memento.game.Gamer;
import memento.game.Memento;

public class Main {
	public static void main(String[] args) {
		Gamer gamer = new Gamer(100);
		Memento memento = gamer.createMemento();
		for(int i=0; i<100;i++) {
			System.out.println("======="+i);
			System.out.println("Present State: "+gamer);
			
			gamer.bet();
			
			System.out.println("your money is: "+gamer.getMoney()+"$");
			
			if(gamer.getMoney()>memento.getMoney()) {
				System.out.println("your money has increased, "
						+ "So, save the state");
				memento = gamer.createMemento();
			}else if(gamer.getMoney() < memento.getMoney()/2) {
				System.out.println("your money increased a lot!"
						+ "so, skip to previous state!");
				gamer.restoreMemento(memento);
			}
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
		}
	}
}
