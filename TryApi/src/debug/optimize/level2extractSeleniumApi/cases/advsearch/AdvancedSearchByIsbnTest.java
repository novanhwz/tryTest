package debug.optimize.level2extractSeleniumApi.cases.advsearch;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import debug.optimize.level2extractSeleniumApi.framework.SeleniumTestAbstract;
import debug.optimize.level2extractSeleniumApi.pages.AdvancedSearchPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.HomePageUtil;
import debug.optimize.level2extractSeleniumApi.pages.LoginPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.SearchResultListPageUtil;

public class AdvancedSearchByIsbnTest extends SeleniumTestAbstract {
	//

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keyword = "0-674-03612-3";
	String searchField = "ISBN/UPC/EAN";

	@Test
	public void loginwithComplexaction() {

		LoginPageUtil.login(userName, password);
		HomePageUtil.enterAdvancedSearchPage();
		AdvancedSearchPageUtil.search(keyword, searchField);

		// counter the result and return counternumber
		int matchedcounter = 0;
		int sizeofbipnumber = 0;

		List<WebElement> bipnumber = SearchResultListPageUtil.findISBNElement();
	
		for (int i = 0; i < sizeofbipnumber; i++) {
			String str1 = bipnumber.get(i).getText();
			str1 = str1.toLowerCase();
			matchedcounter = (str1.indexOf(keyword) >= 0 ? matchedcounter + 1
					: matchedcounter);
		}

		System.out.println("total find " + matchedcounter
				+ " kind of book with " + keyword);
	}

}
