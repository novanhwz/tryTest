/*
 * History
 * Date        Ver Author        Change Description
 * ----------- --- ------------- ----------------------------------------
 * 18 Jun 2015 001 XX            Create
 */
package debug.optimize.level2extractSeleniumApi.pages;

import org.openqa.selenium.By;

import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class AdvancedSearchPageUtil {

	public static By ADVANCED_INPUT_FRAM_CONDITION1 = By.id("txtRow1");
	public static By ADVANCED_SELECTOPTION1 = By.id("selRow1");
	public static By ADVANCED_BUTTON_SEARCH = By.id("btnPrimarySrch");
	
	public static void waitForPageToLoad() {
		// NOTE: advanced search is not stable, wait it to load completely. 
		SeleniumUtil.waitForFixedMilliseconds(1500);
	}
	
	public static void search(String keyword, String searchField) {
		SeleniumUtil.clearSendKeys(ADVANCED_INPUT_FRAM_CONDITION1, keyword);
	
		// select option
		SeleniumUtil.selectByVisibleText(ADVANCED_SELECTOPTION1, searchField);
		// click search button
		SeleniumUtil.click(ADVANCED_BUTTON_SEARCH);
		SearchResultListPageUtil.waitForPageToLoad();
	}

	
}
