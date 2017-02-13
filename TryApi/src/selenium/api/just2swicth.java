package selenium.api;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class just2swicth {
	
		// W3C PAGE
		By input_inGoogle=By.id("lst-ib");
		By Button_Google=By.xpath("//span[contains(@class,'sbico')]");
	
		//google page
		By GOOGLE_FIRST_RESULT_W3C=By.xpath("(//h3[contains(@class,'r')])[1]");
		
		//w3c page which can find result
		By HyperlinktodisplayAlterpage=By.xpath("//a[contains(text(),'显示一个对话框')]");

		// RESULT_PAGE
		By BUTTON_DISPLAY = By.xpath("//input[contains(@type,'button')]");
		
		

		@Test
		public void handleAlert() {

			FirefoxProfile profile = new ProfilesIni().getProfile("default");
			WebDriver driver=new FirefoxDriver(profile);
			driver.manage().window().maximize();
					
			driver.get("https://www.google.com/");
			WebElement elememtInputsearchw3c = driver.findElement(input_inGoogle);
			elememtInputsearchw3c.sendKeys("alert site:w3school.com.cn");
			WebElement searchbutton = driver.findElement(Button_Google);
			searchbutton.click();
			waitformiliseconds(5000);

			String winHandle2=driver.getWindowHandle();
			driver.switchTo().window(winHandle2);
			
			// click the first result for W3C
			WebElement firstresultw3c = driver.findElement(GOOGLE_FIRST_RESULT_W3C);
			firstresultw3c.click();
			waitformiliseconds(5000);

			WebElement w3cresult=driver.findElement(HyperlinktodisplayAlterpage);
			w3cresult.click();
			
			WebElement elementdisplayalert = driver.findElement(BUTTON_DISPLAY);
			elementdisplayalert.click();

		}

		
		public static void waitformiliseconds(int miliseconds) {
			try {
				Thread.sleep(miliseconds);
			} catch (InterruptedException e) {

			}

		}

	
	}


