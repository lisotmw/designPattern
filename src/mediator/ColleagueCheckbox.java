package mediator;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements Colleague,ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Mediator mediator;
	
	public ColleagueCheckbox(String caption, CheckboxGroup g, boolean state) {
		super(caption,g,state);
	}
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void colleagueChange(boolean isChange) {
		setEnabled(isChange);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		mediator.changeColleague();
	}

}
