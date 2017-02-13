/*
 * History
 * Date        Ver Author        Change Description
 * ----------- --- ------------- ----------------------------------------
 * 18 Jun 2015 001 XX            Create
 */
package debug.optimize.level2extractSeleniumApi.pages;

import org.openqa.selenium.By;

import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class HomePageUtil {

	public static By HOME_SPAN_KEYWORD_TYPE = By.id("selectedVal");
	public static By HOME_LI_SUBJECT = By.xpath("//*[@id='searchTypeUl']/li/a[text()='Subject']");
	public static By HOME_LI_TITLE = By.xpath("//*[@id='searchTypeUl']/li/a[text()='Title']");
	public static By HOME_LI_CHARACTER = By.xpath("//*[@id='searchTypeUl']/li/a[text()='Character']");
	public static By HOME_LI_PUBLISHER = By.xpath("//*[@id='searchTypeUl']/li/a[text()='Publisher']");
	public static By HOME_LI_SERIESTITLE = By.xpath("//*[@id='searchTypeUl']/li/a[text()='Series Title']");
	public static By HOME_LI_AUTHOR = By.xpath("//*[@id='searchTypeUl']/li/a[text()='Author']");
	public static By HOME_INPUT_KEYWORD = By.id("txtSearch");
	public static By HOME_SPAN_SEARCH_ICON = By.id("searchButtonGO");
	
	
	public static By HOMEPAGE_ADVANCED_SEARCH_ICON = By.id("advanceSearch");
	
	public static void waitForPageToLoad() {
		// NOTE: wait for home page to load
		SeleniumUtil.waitForFixedMilliseconds(7000);
	}

	public static void searchBySubject(String keyword) {
		search(HOME_LI_SUBJECT, keyword);
	}
	
	public static void searchByTitle(String keyword) {
		search(HOME_LI_TITLE, keyword);
	}
	
	// TODO
	public static void searchByAuthor(String keyword) {
		search(HOME_LI_AUTHOR, keyword);
	}
	
	public static void searchByCharacter(String keyword) {
		search(HOME_LI_CHARACTER, keyword);
	}
	
	public static void searchByPublisher(String keyword) {
		search(HOME_LI_PUBLISHER, keyword);
	}
	
	public static void searchBySeriesTitle(String keyword) {
		search(HOME_LI_SERIESTITLE, keyword);
	}
	
	private static void search(By keywordTypeBy, String keyword) {
		// 先定位下拉菜单
		SeleniumUtil.click(HOME_SPAN_KEYWORD_TYPE);
		SeleniumUtil.click(keywordTypeBy);
		
		SeleniumUtil.sendKeys(HOME_INPUT_KEYWORD, keyword);
		SeleniumUtil.click(HOME_SPAN_SEARCH_ICON);
		SearchResultListPageUtil.waitForPageToLoad();
	}
	

	/*public static void search(String keywordType, String keyword) {
		// 先定位下拉菜单
		SeleniumUtil.click(HOME_SPAN_KEYWORD_TYPE);
		SeleniumUtil.click(keywordTypeBy);
		
		SeleniumUtil.sendKeys(HOME_INPUT_KEYWORD, keyword);
		SeleniumUtil.click(HOME_SPAN_SEARCH_ICON);
		SearchResultListPageUtil.waitForPageToLoad();
	}*/
	
	public static void enterAdvancedSearchPage() {
		SeleniumUtil.click(HOMEPAGE_ADVANCED_SEARCH_ICON);
		AdvancedSearchPageUtil.waitForPageToLoad();
	}

	
}
