/*
 * History
 * Date        Ver Author        Change Description
 * ----------- --- ------------- ----------------------------------------
 * 18 Jun 2015 001 XX            Create
 */
package debug.optimize.level2extractSeleniumApi.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class SearchResultListPageUtil {

	 /* Result list page elements */
	public static By RL_LINK_RECORD_LINKS = By.xpath("//a[contains(@class, 'classiclink notranslate')]");
	public static By RL_LINK_RECORD_LINKS_goto_Secondpage = By.xpath("//a[contains(@class, 'classiclink notranslate')]");
	public static By RL_LINK_RECORD_LINKS_SERIESTITLE = By
			.xpath(".//*[contains(text(),'Series Title')]/following-sibling::dd/a");
	
	public static By RL_RECORD_ISBN = By.xpath(".//*[contains(text(),'ISBN-10')]/following-sibling::dd");

		
	public static void waitForPageToLoad() {
		// TODO will change it later
		SeleniumUtil.waitForFixedMilliseconds(5000);
	}
	
	public static List<WebElement> getAllRecordLinks() {
		return SeleniumUtil.findElements(RL_LINK_RECORD_LINKS);
	}
	
	public static int getRecordCountNeedGotoDetailedPage() {
		return SeleniumUtil.findElements(RL_LINK_RECORD_LINKS_goto_Secondpage).size();
	}
	
	public static List<WebElement> findSeriesTitleElement() {
		List<WebElement> elementSeriesTitle=SeleniumUtil.findElements(RL_LINK_RECORD_LINKS_SERIESTITLE);
		return elementSeriesTitle;
	}
	
	public static List<WebElement> findISBNElement() {
		List<WebElement> elementSeriesTitle=SeleniumUtil.findElements(RL_RECORD_ISBN);
		return elementSeriesTitle;
	}
	
	public static  void enterDetailedInfoPage(int i) {
		By currentRecordLinkBy = By
			.xpath("(//*[@id='resulttable']/tbody/tr/td[3]/div/h5/a)[" + (i + 1) + "]");
		SeleniumUtil.click(currentRecordLinkBy);
		SeleniumUtil.waitForFixedMilliseconds(8000);
	
	}
	
	
}
