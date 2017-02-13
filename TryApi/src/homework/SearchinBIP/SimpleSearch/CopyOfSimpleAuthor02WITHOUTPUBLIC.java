package homework.SearchinBIP.SimpleSearch;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class CopyOfSimpleAuthor02WITHOUTPUBLIC {
	
private static final String SIGN_IN_LINK = "http://aws.preprod.booksinprint.com/";
	
	// Page definition goes here
	/* Login page elements */
	By LOGIN_INPUT_USER_NAME = By.id("loginID");
	By LOGIN_INPUT_PASSWORD = By.id("password");
	By LOGIN_BUTTON_LOG_IN = By.xpath("//*[@id='loginForm']/div[5]/div[2]/input");

	/* Home page elements */
	By HOME_SPAN_KEYWORD_TYPE = By.id("selectedVal");
	By HOME_LI_SUBJECT = By.xpath("//*[@id='searchTypeUl']/li[4]");
	By HOME_INPUT_KEYWORD = By.id("txtSearch");
	By HOME_SPAN_SEARCH_ICON = By.id("searchButtonGO");
	
	/* Result list page elements */
	By RL_LINK_RECORD_LINKS = By.xpath("//a[contains(@class, 'classiclink notranslate')]");
	
	/* Record detail page elements */
	By RD_SPAN_FIRST_MATCHED_SUBJECT = By.xpath("(//a[contains(text(),'China')])[1]");

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keyword = "china";

	@Test
	public void loginwithComplexaction(){
		WebDriver driver = openFirefox();
		login(driver, userName, password);
        search(driver, keyword);
    
        int matchedCount = 0;
        int recordCount = getRecordCount(driver);
        
        for (int i = 0; i < recordCount; i++) {
        	String str1 = enterRecordAndGetFirstSubject(driver, i);                       
            matchedCount = (str1.indexOf(keyword)>=0 ? matchedCount + 1 : matchedCount);
            
            driver.navigate().back();
            waitForFixedMilliseconds(9000);
		}
        
        System.out.println("totoal find "+matchedCount+" kind of book with charactor China");
        
        closeBrowser(driver);
	}

	private WebDriver openFirefox() {
		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		WebDriver driver=new FirefoxDriver(profile);
		driver.manage().window().maximize();
		
		driver.get(SIGN_IN_LINK);
		return driver;
	}

	private void login(WebDriver driver, String userName, String password) {
		WebElement element1 = driver.findElement(LOGIN_INPUT_USER_NAME);
		clearSendKeys(element1, userName );
		waitForFixedMilliseconds(500);
		
		WebElement element2 = driver.findElement(LOGIN_INPUT_PASSWORD);
		clearSendKeys(element2, password );
		waitForFixedMilliseconds(500);
		
		driver.findElement(LOGIN_BUTTON_LOG_IN).click();
		// NOTE: wait for login
		waitForFixedMilliseconds(7000);
	}
	
	private void search(WebDriver driver, String keyword) {
		// 先定位下拉菜单
        driver.findElement(HOME_SPAN_KEYWORD_TYPE).click();
        // 然后定位到下拉菜单中的其中一个选项，最后click
        driver.findElement(HOME_SPAN_KEYWORD_TYPE)
        	.findElement(HOME_LI_SUBJECT).click();
        WebElement e3 = driver.findElement(HOME_INPUT_KEYWORD);
        e3.sendKeys(keyword);
        driver.findElement(HOME_SPAN_SEARCH_ICON).click();
        
        // NOTE: wait after search result is displayed
        waitForFixedMilliseconds(5000);
	}
	
	private int getRecordCount(WebDriver driver) {
		return driver.findElements(RL_LINK_RECORD_LINKS).size();
	}
	
	private String enterRecordAndGetFirstSubject(WebDriver driver, int i) {
		By currentRecordLinkBy = By.xpath("(//*[@id='resulttable']/tbody/tr/td[3]/div/h5/a)[" + (i+1) + "]");
		WebElement currentLink = driver.findElement(currentRecordLinkBy);
		currentLink.click();
		waitForFixedMilliseconds(8000);
		
		WebElement firstMatchedSubject=driver.findElement(RD_SPAN_FIRST_MATCHED_SUBJECT);
		String str1=firstMatchedSubject.getText();
		str1=str1.toLowerCase();
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
		} catch (InterruptedException e) { }
	}
	
	private void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
		
}
