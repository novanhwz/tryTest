package selenium.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DataTimegetMethod {
	
	@Test
	
	public void getDateTimeStampString(){
		String t1=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-S-SS").format(new Date());
		
		Date t2=new SimpleDateFormat().get2DigitYearStart();
		int i=(int) t2.getTime();
		
		System.out.println(t1);
		System.out.println(i);
		
	}

}
