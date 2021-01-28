package memento.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
	private int money;
	private List fruits = new ArrayList();
	private Random r = new Random();
	private static String[] fruitsname = {
			"Apple","Grape","Banana","Orange"
			};
	public Gamer(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	public void bet() {
		int dice = r.nextInt(6)+1;
		if(dice==1) {
			money += 100;
			System.out.println("your money is increasing");
		}else if(dice == 2) {
			money /= 2;
			System.out.println("Half money");
		}else if(dice == 6) {
			String f = getFruit();
			System.out.println("You get the fruit!");
			fruits.add(f);
		}else
			System.out.println("Nothing happened!");
	}
	
	public Memento createMemento() {
		Memento m = new Memento(money);
		Iterator it = fruits.iterator();
		while(it.hasNext()) {
			String f = (String)it.next();
			if(f.startsWith("Tasty"))
				m.addFruit(f);
		}
		return m;
	}
	
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}
	
	public String toString() {
		return "[money = "+money+", fruits = "+fruits+"]";
	}
	
	private String getFruit() {
		String prefix = "";
		if(r.nextBoolean())
			prefix = "Tasty";
		return prefix+fruitsname[r.nextInt(fruitsname.length)];
	}
	
}
