package debug.optimize.level2extractSeleniumApi.cases.advsearch;

import org.junit.Test;
import org.openqa.selenium.By;

import debug.optimize.level2extractSeleniumApi.framework.SeleniumTestAbstract;
import debug.optimize.level2extractSeleniumApi.pages.AdvancedSearchPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.DetailedInfoPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.HomePageUtil;
import debug.optimize.level2extractSeleniumApi.pages.LoginPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.SearchResultListPageUtil;
import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class AdvancedSearchbyAuthorTest extends SeleniumTestAbstract {

	/* Record detail page elements */
	By RD_SPAN_FIRST_MATCHED_SUBJECT = By
			.xpath("(//a[contains(text(),'China')])[1]");

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keywords = "china";
	String dropdownoption_Author = "Author/Contributor";

	@Test
	public void loginwithComplexaction() {
		LoginPageUtil.login(userName, password);
		HomePageUtil.enterAdvancedSearchPage();
		AdvancedSearchPageUtil.search(keywords, dropdownoption_Author);

		// counter the result and return countenumber
		int matchedCount = 0;
		int recordCount = SearchResultListPageUtil.getAllRecordLinks().size();

		for (int i = 0; i < recordCount; i++) {
			SearchResultListPageUtil.enterDetailedInfoPage(i);
			String str1 = DetailedInfoPageUtil.getMacthcedAuthorwithChina();
			matchedCount = (str1.indexOf(keywords) >= 0 ? matchedCount + 1
					: matchedCount);
			SeleniumUtil.back();
			SeleniumUtil.waitForFixedMilliseconds(9000);
		}

		System.out.println("total find " + matchedCount
				+ " kind of book with Author name " + keywords);

		SeleniumUtil.closeBrowser();
	}
}
