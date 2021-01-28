package mediator;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements Colleague, TextListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Mediator mediator;
	
	public ColleagueTextField(String caption, int columns) {
		super(caption,columns);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void colleagueChange(boolean isChange) {
		setEnabled(isChange);
		setBackground(isChange ? Color.WHITE : Color.GRAY);
	}

	@Override
	public void textValueChanged(TextEvent e) {
		mediator.changeColleague();
	}

}
