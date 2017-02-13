package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class xpath {
	
	@Test
	public void getXpathelement(){
		// LoadDriver
				WebDriver driver = new FirefoxDriver();
				String bipurl = "http://aws.preprod.booksinprint.com/UI/Pages/SignIn.aspx";
				driver.get(bipurl);

				WebElement element1 = driver.findElement(By.id("UCLogin_txtUserName"));
				element1.sendKeys("SelAdmin");
				WebElement element2 = driver.findElement(By.id("UCLogin_txtPassword"));
				element2.sendKeys("12345678");
				driver.findElement(By.id("UCLogin_lnkLogin")).click();
				driver.findElement(By.id("txtSearch")).sendKeys("84-8063-666-1");

				driver.findElement(By.id("btnSearch")).click();

				
				
				
				WebElement Elementlist = driver.findElement(By.xpath(".//*[@id='resulttable']/tbody/tr[4]/td[3]/div[2]/dl[2]/dd"));

			//System.out.println(Elementlist);	
				driver.quit();
				}

}
