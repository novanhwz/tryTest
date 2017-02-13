package selenium.api;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StringSub {

	@Test
	public void openConcurrentPage() {
		String str1="Enduser:---- Any ----";
		String a[]=str1.split("-");
		System.out.println(a[0]);
}
}
