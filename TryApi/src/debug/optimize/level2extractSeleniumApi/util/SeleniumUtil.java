/*
 * History
 * Date        Ver Author        Change Description
 * ----------- --- ------------- ----------------------------------------
 * 15 Jun 2015 001 XX            Creates
 *                                   
 */
package debug.optimize.level2extractSeleniumApi.util;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.SeleneseTestBase;

public class SeleniumUtil {

	private static WebDriver driver = null;
	
	private static final SeleneseTestBase testbase = new SeleneseTestBase();
	
	public static void openFirefox() {
		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		driver=new FirefoxDriver(profile);
		driver.manage().window().maximize();

	}

	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	public static void get(String url) {
		driver.get(url);
	}
	
	public static void switchToFrame(String frameNameOrId) {
		driver.switchTo().frame(frameNameOrId);
	}
	
	public static Alert switchToAlert() {
		return driver.switchTo().alert();
	}
	
	public static WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	public static List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}
	
	public static void sendKeys(By by, String keyword) {
		findElement(by).sendKeys(keyword);
		
	}
	
	public static void selectByVisibleText(By by, String text) {
		Select dropdown = new Select(SeleniumUtil.findElement(by));
		dropdown.selectByVisibleText(text);
	}
	
	public static void clearSendKeys(By by, String value) {
		findElement(by).clear();
		sendKeys(by, value);
	}
	
	public static void click(By by) {
		findElement(by).click();
	}
	
	public static String getText(By by) {
		return findElement(by).getText();
	}
	
	public static String getTrimText(By by) {
		return getText(by).trim();
	}

	public static int getRecordCount(By by) {
		return findElements(by).size();
	}
	
	public static void waitForFixedMilliseconds(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) { }
	}

	public static void back() {
		driver.navigate().back();
	}
	
	public static String getBodyText() {
		return findElement(By.xpath("/html/body")).getText();
	}
	
	public static void closeBrowser() {
		quit();
	}

	public static void quit() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static final void assertEquals(Object expected, Object actual) {
		SeleneseTestBase.assertEquals(expected, actual);
	}

	/**Like JUnit's Assert.assertEquals, compare two strings */
	public static final void assertEquals(String expected, String actual) {
		SeleneseTestBase.assertEquals(expected, actual);
	}

	/**Like JUnit's Assert.assertEquals, compare two string arrays */
	public static final void assertEquals(String[] expected, String[] actual) {
		SeleneseTestBase.assertEquals(expected, actual);
	}
	
	/**Like JUnit's Assert.assertTrue, if true then pass*/
	public static final void assertTrue(boolean condition) {
		SeleneseTestBase.assertTrue(condition);
	}
	
	/**Like JUnit's Assert.assertTrue with message, if true then pass*/
	public static final void assertTrue(String message, boolean condition) {
		SeleneseTestBase.assertTrue(message, condition);
	}

	/**Like JUnit's Assert.assertFalse, if false then pass*/
	public static final void assertFalse(boolean condition) {
		SeleneseTestBase.assertFalse(condition);
	}

	/**Asserts that two boolean values are not the same*/
	public static final void assertNotEquals(boolean expected, boolean actual) {
		SeleneseTestBase.assertNotEquals(expected, actual);
	}

	/**Asserts that two objects are not the same*/
	public static final void assertNotEquals(Object expected, Object actual) {
		SeleneseTestBase.assertNotEquals(expected, actual);
	}

	@SuppressWarnings("static-access")
	public static final void fail(String errorMessage){
		testbase.fail(errorMessage);
	}
	
	public static void assertEnabled(WebElement element){
		SeleniumUtil.assertTrue(element.isEnabled());
	}
	
}
