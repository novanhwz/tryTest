package selenium.api;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class AlertHandleExercise {

	// homepage of baidu
	By BAIDUinput = By.id("kw");
	By BAIDU_SEARCH_BUTTON = By.id("su");

	// Result list of baidu
	By BAIDUPAGE_FIRST_RESULT_W3C = By.xpath("//a[contains(@class,'favurl')]");

	// W3C PAGE
	By W3CPAGE_INPUT_KEYWORDS = By.xpath("//*[@id='searched_content']");
	By W3CPAGE_BUTTON_GO = By.xpath("//input[contains(@class,'button')]");

	// google page
	By GOOGLE_LINK_FIRST_RESULT_W3C = By
			.xpath("(//h3[contains(@class,'r')]/a)[1]");

	// w3c page which can find result
	By W3CPAGE_HyperlinktodisplayAlterpage = By
			.xpath("//a[contains(text(),'显示一个对话框')]");

	// RESULT_PAGE
	By W3C_BUTTON_DISPLAY = By.xpath("//input[contains(@type,'button')]");

	@Test
	public void handleAlert() {

		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		WebDriver driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();

		driver.get("http://www.baidu.com/");
		
		String windowHandle1=driver.getWindowHandle();
		WebElement elememtInputsearchw3c = driver.findElement(BAIDUinput);
		elememtInputsearchw3c.sendKeys("w3cschool");
		WebElement clickbuton = driver.findElement(BAIDU_SEARCH_BUTTON);
		clickbuton.click();

		waitformiliseconds(1500);

		// click the first result for W3C
		WebElement firstresultlinbaiduresultlist = driver
				.findElement(BAIDUPAGE_FIRST_RESULT_W3C);
		firstresultlinbaiduresultlist.click();

		SeleniumUtil.waitForFixedMilliseconds(5000);

		String windowHandle2=driver.getWindowHandle();
		driver.switchTo().window(windowHandle2);

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		WebElement elementInputKey = driver.findElement(W3CPAGE_INPUT_KEYWORDS);
		waitformiliseconds(5000);
		elementInputKey.sendKeys("alert");
		WebElement elementgobutton = driver.findElement(W3CPAGE_BUTTON_GO);
		elementgobutton.click();

		/*
		 * String winHandle2=driver.getWindowHandle();
		 * driver.switchTo().window(winHandle2);
		 */

		// wait 5 seconds to
		waitformiliseconds(5000);

		WebElement googlefirstresult = driver
				.findElement(GOOGLE_LINK_FIRST_RESULT_W3C);
		googlefirstresult.click();
		waitformiliseconds(5000);

		WebElement w3cresult = driver.findElement(W3CPAGE_HyperlinktodisplayAlterpage);
		w3cresult.click();

		WebElement elementdisplayalert = driver.findElement(W3C_BUTTON_DISPLAY);
		elementdisplayalert.click();

	}
	
	

	void waitformiliseconds(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {

		}

	}

}
