package selenium.api;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class localdate {
	
	@Test
	public void test(){
		Date dt = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 
		 String sDateTime = formatter.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
		 System.out.println(sDateTime);
		 
		
		StringBuffer buffer = new StringBuffer();

	    Calendar date = Calendar.getInstance();
	    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
	    
	    FieldPosition yearPosition = new FieldPosition(DateFormat.YEAR_FIELD);

	    StringBuffer format = dateFormat.format(date.getTime(), buffer, yearPosition);
	    format.replace(yearPosition.getBeginIndex(), yearPosition.getEndIndex(), String.valueOf(date.get(Calendar.YEAR)));

	    System.out.println(format);
		
	}

}
