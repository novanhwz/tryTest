package JavaBasicLearning;

import org.junit.Test;
import org.openqa.selenium.By;

import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class ClickLiTagTest {

	private static final String SIGN_IN_LINK = "http://aws.preprod.booksinprint.com/";

	// Page definition goes here
	/* Login page elements */
	By LOGIN_INPUT_USER_NAME = By.id("loginID");
	By LOGIN_INPUT_PASSWORD = By.id("password");
	By LOGIN_BUTTON_LOG_IN = By
			.xpath("//*[@id='loginForm']/div[5]/div[2]/input");

	/* Home page elements */
	By HOME_SPAN_KEYWORD_TYPE = By.id("selectedVal");
	By HOME_LI_SUBJECT = By.xpath("//*[@id='searchTypeUl']/li[4]");
	By HOME_INPUT_KEYWORD = By.id("txtSearch");
	By HOME_SPAN_SEARCH_ICON = By.id("searchButtonGO");

	/* Result list page elements */
	By RL_LINK_RECORD_LINKS = By
			.xpath("//a[contains(@class, 'classiclink notranslate')]");

	/* Record detail page elements */
	By RD_SPAN_FIRST_MATCHED_SUBJECT = By
			.xpath("(//a[contains(text(),'China')])[1]");

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keyword = "china";

	@Test
	public void loginwithComplexaction() {
		SeleniumUtil.openFirefox();
		SeleniumUtil.get(SIGN_IN_LINK);
		login(userName, password);
		
	}

	private void login(String userName, String password) {
		SeleniumUtil.clearSendKeys(LOGIN_INPUT_USER_NAME, userName);
		SeleniumUtil.waitForFixedMilliseconds(500);

		SeleniumUtil.clearSendKeys(LOGIN_INPUT_PASSWORD, password);
		SeleniumUtil.waitForFixedMilliseconds(500);

		SeleniumUtil.findElement(LOGIN_BUTTON_LOG_IN).click();
		// NOTE: wait for login
		SeleniumUtil.waitForFixedMilliseconds(7000);
	}

	private void search(String keyword) {
		// 先定位下拉菜单

		SeleniumUtil.click(HOME_LI_SUBJECT);

		SeleniumUtil.click(HOME_LI_SUBJECT);
		SeleniumUtil.findElement(HOME_SPAN_KEYWORD_TYPE).click();

		SeleniumUtil.sendKeys(HOME_INPUT_KEYWORD, keyword);
		SeleniumUtil.click(HOME_SPAN_SEARCH_ICON);

		// NOTE: wait after search result is displayed
		SeleniumUtil.waitForFixedMilliseconds(5000);
	}

	private String enterRecordAndGetFirstSubject(int i) {
		By currentRecordLinkBy = By
				.xpath("(//*[@id='resulttable']/tbody/tr/td[3]/div/h5/a)["
						+ (i + 1) + "]");
		SeleniumUtil.click(currentRecordLinkBy);
		SeleniumUtil.waitForFixedMilliseconds(8000);

		String str1 = SeleniumUtil.getText(RD_SPAN_FIRST_MATCHED_SUBJECT);
		str1 = str1.toLowerCase();
		System.out.println(str1);
		return str1;
	}

}
