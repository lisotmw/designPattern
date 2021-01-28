package mediator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColleagueMediator extends Frame implements ActionListener, Mediator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton bOk;
	private ColleagueButton bCancel;
	
	public ColleagueMediator(String caption) {
		super(caption);
		setBackground(Color.lightGray);
		setLayout(new GridLayout(4,2));
		createColleague();
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(bOk);
		add(bCancel);
		
		changeColleague();
		pack();
		setVisible(true);
	}
	
	@Override
	public void createColleague() {
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest",g,true);
		checkLogin = new ColleagueCheckbox("Login",g,true);
		textUser = new ColleagueTextField("",10);
		textPass = new ColleagueTextField("",10);
		textPass.setEchoChar('*');
		bOk = new ColleagueButton("OK");
		bCancel = new ColleagueButton("Cancel");
		
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		bOk.setMediator(this);
		bCancel.setMediator(this);
		
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		bOk.addActionListener(bOk);
		bCancel.addActionListener(bCancel);
	}

	@Override
	public void changeColleague() {
		if(checkGuest.getState()) {
			textUser.colleagueChange(false);
			textPass.colleagueChange(false);
			bOk.colleagueChange(true);
		}else {
			textUser.colleagueChange(true);
			passChanged();
		}
	}
	
	private void passChanged() {
		if(textUser.getText().length() > 0) {
			textPass.colleagueChange(true);
			if(textPass.getText().length() > 0) {
				bOk.colleagueChange(true);
			}else {
				bOk.colleagueChange(false);
			}
		}else {
			textPass.colleagueChange(false);
			bOk.colleagueChange(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(1);
	}

}
