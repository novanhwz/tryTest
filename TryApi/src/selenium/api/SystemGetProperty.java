package selenium.api;

import org.junit.Test;

public class SystemGetProperty {
	
	@Test
	public void getSystemProperty(){
		String env = System.getProperty("env");
		
		System.out.println(env);
	}

}
