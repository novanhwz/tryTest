package homework.SearchinBIP.AdvancedSearch;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSearchingbySeriesTitle {

	private static final String SIGN_IN_LINK = "http://aws.preprod.booksinprint.com/";

	// Page definition goes here
	/* Login page elements */
	By LOGIN_INPUT_USER_NAME = By.id("loginID");
	By LOGIN_INPUT_PASSWORD = By.id("password");
	By LOGIN_BUTTON_LOG_IN = By
			.xpath("//*[@id='loginForm']/div[5]/div[2]/input");

	/* Home page elements */
	By HOMEPAGE_ADVANCEDSEARCHING = By.id("advanceSearch");

	/* Advance searching page */
	By ADVANCED_INPUTFRAM_CONDITION1 = By.id("txtRow1");
	By ADVANCED_SELECTOPTION1 = By.id("selRow1");
	By ADVANCED_SEARCHBUTTON = By.id("btnPrimarySrch");

	/* Result list page elements */
	By RL_LINK_RECORD_LINKS = By
			.xpath(".//*[contains(text(),'Series Title')]/following-sibling::dd/a");

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keywords = "china";
	String bipnumoption_SeriesTitle = "Series Title";

	@Test
	public void loginwithComplexaction() {
		WebDriver driver = openFirefox();
		login(driver, userName, password);
		WebElement advancedbutton = driver
				.findElement(HOMEPAGE_ADVANCEDSEARCHING);
		advancedbutton.click();

		// advanced page input frame
		fillCondtioninAdvancedpage(driver);
		
		//counter the result and return counternumber
		int matchedcounter=0;
		int sizeofbipnumber=0;
		List<WebElement> bipnumber=driver.findElements(RL_LINK_RECORD_LINKS);
		sizeofbipnumber=bipnumber.size();
		
		for(int i=0; i<sizeofbipnumber; i++){
			String str1=bipnumber.get(i).getText();
			str1=str1.toLowerCase();
            matchedcounter = (str1.indexOf(keywords)>=0 ? matchedcounter + 1 : matchedcounter);
			}
		
		 System.out.println("total find "+matchedcounter+" kind of book with"+ bipnumoption_SeriesTitle);
	        
	        closeBrowser(driver);

		// closeBrowser(driver);

	}

	private WebDriver openFirefox() {
		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		WebDriver driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();

		driver.get(SIGN_IN_LINK);
		return driver;
	}

	private void login(WebDriver driver, String userName, String password) {
		WebElement element1 = driver.findElement(LOGIN_INPUT_USER_NAME);
		clearSendKeys(element1, userName);
		waitForFixedMilliseconds(500);

		WebElement element2 = driver.findElement(LOGIN_INPUT_PASSWORD);
		clearSendKeys(element2, password);
		waitForFixedMilliseconds(500);

		driver.findElement(LOGIN_BUTTON_LOG_IN).click();
		// NOTE: wait for login
		waitForFixedMilliseconds(7000);
	}

	private void fillCondtioninAdvancedpage(WebDriver driver) {
		WebElement inputfram = driver
				.findElement(ADVANCED_INPUTFRAM_CONDITION1);
		clearSendKeys(inputfram, keywords);
		//select option 
		Select dropdown = new Select(driver.findElement(ADVANCED_SELECTOPTION1));
		dropdown.selectByVisibleText(bipnumoption_SeriesTitle);
		// click search button
		WebElement searchbutton=driver.findElement(ADVANCED_SEARCHBUTTON);
		searchbutton.click();
		waitForFixedMilliseconds(500);
	}
	private void clearSendKeys(WebElement element1, String value) {
		element1.clear();
		element1.sendKeys(value);
	}

	private void waitForFixedMilliseconds(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}

	private void closeBrowser(WebDriver driver) {
		driver.quit();
	}

}
