package homework.SearchinBIP.SimpleSearch;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class SimpleSeriesWithoutPublicClass {

	private static final String SIGN_IN_LINK = "http://aws.preprod.booksinprint.com/";

	// Page definition goes here
	/* Login page elements */
	By LOGIN_INPUT_USER_NAME = By.id("loginID");
	By LOGIN_INPUT_PASSWORD = By.id("password");
	By LOGIN_BUTTON_LOG_IN = By
			.xpath("//*[@id='loginForm']/div[5]/div[2]/input");

	/* Home page elements */
	By HOME_SPAN_KEYWORD_TYPE = By.id("selectedVal");
	By HOME_LI_SERIES_TITLE = By.xpath("//*[@id='searchTypeUl']/li[6]");
	By HOME_INPUT_KEYWORD = By.id("txtSearch");
	By HOME_SPAN_SEARCH_ICON = By.id("searchButtonGO");

	/* Result list page elements */
	By RL_LINK_RECORD_LINKS = By
			.xpath("//dt[contains(text(),' Series Title')]/following-sibling::dd/a");

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keyword = "china";

	@Test
	public void loginwithComplexaction() {
		WebDriver driver = openFirefox();
		login(driver, userName, password);
		search(driver, keyword);

		int matchedCount = 0;
		List<WebElement> elementSeriesTitle = driver
				.findElements(RL_LINK_RECORD_LINKS);

		for (int i = 0; i < elementSeriesTitle.size(); i++) {
			String str1 = elementSeriesTitle.get(i).getText();
			str1 = str1.toLowerCase();
			System.out.println(str1);
			matchedCount = (str1.indexOf(keyword) >= 0 ? matchedCount + 1
					: matchedCount);
		}

		System.out.println("totoal find " + matchedCount
				+ " kind of book with Series Title China");

		closeBrowser(driver);
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

	private void search(WebDriver driver, String keyword) {
		// 先定位下拉菜�?
		driver.findElement(HOME_SPAN_KEYWORD_TYPE).click();
		// 然后定位到下拉菜单中的其中一个�?�项，最后click
		driver.findElement(HOME_SPAN_KEYWORD_TYPE)
				.findElement(HOME_LI_SERIES_TITLE).click();
		WebElement e3 = driver.findElement(HOME_INPUT_KEYWORD);
		e3.sendKeys(keyword);
		driver.findElement(HOME_SPAN_SEARCH_ICON).click();

		// NOTE: wait after search result is displayed
		waitForFixedMilliseconds(5000);
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
