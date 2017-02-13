package selenium.api;

import org.junit.Test;

public class SystemCurrentTimeMills {
	
	@Test
	public void getSystemCurrenTimeMillss(){
		
		 String companyName = "test" + System.currentTimeMillis();
		 
		 System.out.println(companyName);
	}

}
