package observer;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
	private ArrayList observers = new ArrayList();
	public void addObserver(Observer ob) {
		observers.add(ob);
	}
	public void deleteObserver(Observer ob) {
		observers.remove(ob);
	}
	
	public void notifyObservers() {
		Iterator it = observers.iterator();
		while(it.hasNext()) {
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}
	
	public abstract int getNum();
	public abstract void execute();
}
