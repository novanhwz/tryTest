package Selenium_comeback_topreviouswebpage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PreviousWebpapage {
	@Test
	public void comeBacktoPreviouspage(){
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.baidu.com/");
		driver.findElement(By.xpath(".//*[@id='nv']/div/a[1]")).click();
		String winHandleBefore = driver.getWindowHandle();
		System.out.println(winHandleBefore);
		
		driver.quit();
		
	}

	
	

}
