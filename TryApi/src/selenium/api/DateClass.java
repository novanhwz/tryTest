package selenium.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateClass {
	
	/*@Test
	public void GetDate(){
		
		Date dt = new Date();
		 System.out.println(dt.toString());   //java.util.Date的含义
		
		 long lSysTime1 = dt.getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
		 System.out.println(lSysTime1);  
		 
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 
		 String sDateTime = formatter.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
		 System.out.println(sDateTime);
	}*/

	
	@Test
	public void testDate(){
		Date dt2 = new Date();
		SimpleDateFormat dateFormate1 = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss.S aa");
		SimpleDateFormat dateFormate2 = new SimpleDateFormat("HH/MM/ss"); 
		SimpleDateFormat dateFormate3 = new SimpleDateFormat("HH:MM:ss");
		//•a - Am/pm marker
		SimpleDateFormat dateFormate4 = new SimpleDateFormat("HH:MM:ss a"); 
		
		String DateTime1 = dateFormate1.format(dt2);
		String DateTime2 = dateFormate2.format(dt2);
		String DateTime3 = dateFormate3.format(dt2);
		String DateTime4 = dateFormate4.format(dt2);
		
		System.out.println(DateTime1);
		System.out.println(DateTime2);
		System.out.println(DateTime3);
		System.out.println(DateTime4);
	}
}
