/*
 * History
 * Date        Ver Author        Change Description
 * ----------- --- ------------- ----------------------------------------
 * 18 Jun 2015 001 XX            Create
 */
package debug.optimize.level2extractSeleniumApi.pages;

import org.openqa.selenium.By;

import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class LoginPageUtil {

	public static final String SIGN_IN_LINK = "http://aws.preprod.booksinprint.com/";
	
	public static By LOGIN_INPUT_USER_NAME = By.id("loginID");
	public static By LOGIN_INPUT_PASSWORD = By.id("password");
	public static By LOGIN_BUTTON_LOG_IN = By.xpath("//*[@id='loginForm']/div[5]/div[2]/input");
	
	public static void login(String userName, String password) {
		SeleniumUtil.get(SIGN_IN_LINK);
	
		SeleniumUtil.clearSendKeys(LOGIN_INPUT_USER_NAME, userName);
		SeleniumUtil.waitForFixedMilliseconds(500);
	
		SeleniumUtil.clearSendKeys(LOGIN_INPUT_PASSWORD, password);
		SeleniumUtil.waitForFixedMilliseconds(500);
	
		SeleniumUtil.click(LOGIN_BUTTON_LOG_IN);
		HomePageUtil.waitForPageToLoad();
	}

	
	
}
