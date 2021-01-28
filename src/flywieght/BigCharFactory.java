package flywieght;

import java.util.HashMap;

public class BigCharFactory {
	private HashMap<String,BigChar> pool = new HashMap<>();
	private static BigCharFactory instance = new BigCharFactory();
	private BigCharFactory() {
	}
	public static BigCharFactory getInstance() {
		return instance;
	}
	
	public synchronized BigChar getBigChar(char charname) {
		BigChar bc = (BigChar)pool.get("" + charname);
		if(bc == null) {
			bc = new BigChar(charname);
			pool.put("" + charname, bc);
		}
		return bc;
	}
}
