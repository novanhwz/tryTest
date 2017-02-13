package homework.SearchinBIP.AdvancedSearch;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSearchingbyKeywodsinSupplier {

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
	/* Result list page elements */
	By RL_LINK_RECORD_LINKS = By
			.xpath("//a[contains(@class, 'classiclink notranslate')]");

	/* Record detail page elements */
	By RD_SPAN_FIRST_MATCHED_SUBJECT = By
			.xpath(".//*[contains(text(),'Price')]/../following-sibling::div/span/div");

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keywords = "china";
	String dropdownoption_keywordsinSupplier = "Supplier";

	@Test
	public void loginwithComplexaction() {
		WebDriver driver = openFirefox();
		login(driver, userName, password);
		WebElement advancedbutton = driver
				.findElement(HOMEPAGE_ADVANCEDSEARCHING);
		advancedbutton.click();

		// advanced page input frame
		fillCondtioninAdvancedpage(driver);

		// counter the result and return counternumber
		int matchedCount = 0;
		int recordCount = getRecordCount(driver);

		for (int i = 0; i < recordCount; i++) {
			String str1 = enterRecordAndGetFirstSubject(driver, i);
			matchedCount = (str1.indexOf(keywords) >= 0 ? matchedCount + 1
					: matchedCount);

			driver.navigate().back();
			waitForFixedMilliseconds(9000);
		}

		System.out.println("total find " + matchedCount + " kind of book with series subject of "
				+ keywords);

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
		// select option
		Select dropdown = new Select(driver.findElement(ADVANCED_SELECTOPTION1));
		dropdown.selectByVisibleText(dropdownoption_keywordsinSupplier);
		// click search button
		WebElement searchbutton = driver.findElement(ADVANCED_SEARCHBUTTON);
		searchbutton.click();
		waitForFixedMilliseconds(500);
	}

	private int getRecordCount(WebDriver driver) {
		return driver.findElements(RL_LINK_RECORD_LINKS).size();
	}

	private String enterRecordAndGetFirstSubject(WebDriver driver, int i) {
		By currentRecordLinkBy = By
				.xpath("(//*[@id='resulttable']/tbody/tr/td[3]/div/h5/a)["
						+ (i + 1) + "]");
		WebElement currentLink = driver.findElement(currentRecordLinkBy);
		currentLink.click();
		waitForFixedMilliseconds(8000);

		WebElement firstMatchedSubject = driver
				.findElement(RD_SPAN_FIRST_MATCHED_SUBJECT);
		String str1 = firstMatchedSubject.getText();
		str1 = str1.toLowerCase();
		System.out.println(str1);
		return str1;
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
