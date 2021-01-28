package state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener,Context{

	private TextField textClock = new TextField(60); //��ʾ��ǰʱ��
	
	private TextArea textScreen = new TextArea(10,60); //��ʾ�������ĵļ�¼
	
	private Button buttonUse = new Button("ʹ�ý��"); //ʹ�ý�ⰴť
	
	private Button buttonAlarm = new Button("���±���"); //���±�����ť
	
	private Button buttonPhone = new Button("ͨ��"); //����ͨ����ť
	
	private Button buttonExit= new Button("����"); //������ť
	
	private State state = DayState.getInstance(); //��ǰ״̬
	
	public SafeFrame(String tile) {
		super(tile);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());
		//textClock
		add(textClock,BorderLayout.NORTH);
		textClock.setEditable(false);
		//textScreen
		add(textScreen,BorderLayout.CENTER);
		textScreen.setEditable(false);
		//add button
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		//mainScreen
		add(panel,BorderLayout.SOUTH);
		//
		pack();
		setVisible(true);
		//
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	
	@Override
	public void setClock(int hour) {
		String clockString = "����ʱ���ǣ� ";
		if(hour<10)
			clockString += "0" + hour + ":00";
		else
			clockString += hour + ":00";
		System.out.println(clockString);
		textClock.setText(clockString);
		state.doClock(this, hour);
	}

	@Override
	public void changeState(State state) {
		System.out.println();
		this.state = state;
	}

	@Override
	public void callSecurityCenter(String msg) {
		textScreen.append("call! " + msg + "\n");
	}

	@Override
	public void recordLog(String msg) {
		textScreen.append("record ... " + msg + "\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		if(e.getSource() == buttonUse)
			state.doUse(this);
		else if(e.getSource() == buttonAlarm)
			state.doAlarm(this);
		else if(e.getSource() == buttonPhone)
			state.doPhone(this);
		else if(e.getSource() == buttonExit)
			System.exit(0);
		else
			System.out.println("?");
	}

}
