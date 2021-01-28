package state;

public class NightState implements State{

	private static NightState instance = new NightState();
	private NightState() {}
	public static State getInstance() {
		return instance;
	}
	
	@Override
	public void doClock(Context context, int hour) {
		if(hour>=9 || hour<17)
			context.changeState(DayState.getInstance());
	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("����������ʹ�ý�⣡ ");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("���¾��壨���ϣ�");
	}

	@Override
	public void doPhone(Context context) {
		context.recordLog("���ϵ�ͨ��¼��");
	}
	
	public String toString() {
		return "[����]";
	}

}