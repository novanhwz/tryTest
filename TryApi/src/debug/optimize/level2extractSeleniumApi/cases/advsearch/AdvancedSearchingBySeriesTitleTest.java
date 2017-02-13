package debug.optimize.level2extractSeleniumApi.cases.advsearch;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import debug.optimize.level2extractSeleniumApi.framework.SeleniumTestAbstract;
import debug.optimize.level2extractSeleniumApi.pages.AdvancedSearchPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.HomePageUtil;
import debug.optimize.level2extractSeleniumApi.pages.LoginPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.SearchResultListPageUtil;
import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class AdvancedSearchingBySeriesTitleTest extends SeleniumTestAbstract{

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keyword = "china";
	String bipnumoption_SeriesTitle = "Series Title";

	@Test
	public void loginwithComplexaction() {
		LoginPageUtil.login(userName, password);
		HomePageUtil.enterAdvancedSearchPage();
		AdvancedSearchPageUtil.search(keyword, bipnumoption_SeriesTitle);
		// counter the result and return countnumber
		
		int matchedcounter = 0;
		List<WebElement> elementSeriesTitle = SearchResultListPageUtil
				.findSeriesTitleElement();

		for (int i = 0; i < elementSeriesTitle.size(); i++) {
			String str1 = elementSeriesTitle.get(i).getText();
			str1 = str1.toLowerCase();
			matchedcounter = (str1.indexOf(keyword) >= 0 ? matchedcounter + 1
					: matchedcounter);
		}

		SeleniumUtil.assertTrue("On result list page, saw " + elementSeriesTitle.size() + " records, "
			+ "but matched only " + matchedcounter + " records.", 
			elementSeriesTitle.size() == matchedcounter);
		
	}

}
