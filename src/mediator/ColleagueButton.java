package mediator;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ColleagueButton extends Button implements Colleague,ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private Mediator mediator;
	
	public ColleagueButton(String caption) {
		super(caption);
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
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
