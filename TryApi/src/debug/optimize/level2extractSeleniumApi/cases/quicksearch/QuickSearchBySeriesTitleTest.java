package debug.optimize.level2extractSeleniumApi.cases.quicksearch;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import debug.optimize.level2extractSeleniumApi.framework.SeleniumTestAbstract;
import debug.optimize.level2extractSeleniumApi.pages.HomePageUtil;
import debug.optimize.level2extractSeleniumApi.pages.LoginPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.SearchResultListPageUtil;

public class QuickSearchBySeriesTitleTest extends SeleniumTestAbstract {

	/* Result list page elements */

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keyword = "china";

	@Test
	public void loginwithComplexaction() {
		LoginPageUtil.login(userName, password);
		HomePageUtil.searchBySeriesTitle(keyword);

		int matchedCount = 0;

		List<WebElement> elementSeriesTitle = SearchResultListPageUtil.findSeriesTitleElement();

		for (int i = 0; i < elementSeriesTitle.size(); i++) {
			String str1 = elementSeriesTitle.get(i).getText();
			str1 = str1.toLowerCase();
			System.out.println(str1);
			matchedCount = (str1.indexOf(keyword) >= 0 ? matchedCount + 1
					: matchedCount);
		}

		System.out.println("totoal find " + matchedCount
				+ " kind of book with Series Title China");
	}

}
