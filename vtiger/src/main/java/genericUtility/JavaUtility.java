package genericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public String generateSysDateAndTime() {
		Date date=new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
	
	public void generateRandomNo(int limit) {
		
		Random random=new Random();
		random.nextInt(limit);
	}

}
