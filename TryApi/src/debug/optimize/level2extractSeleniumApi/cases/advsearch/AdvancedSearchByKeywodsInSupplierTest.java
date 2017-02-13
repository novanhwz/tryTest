package debug.optimize.level2extractSeleniumApi.cases.advsearch;

import org.junit.Test;

import debug.optimize.level2extractSeleniumApi.framework.SeleniumTestAbstract;
import debug.optimize.level2extractSeleniumApi.pages.AdvancedSearchPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.DetailedInfoPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.HomePageUtil;
import debug.optimize.level2extractSeleniumApi.pages.LoginPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.SearchResultListPageUtil;
import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class AdvancedSearchByKeywodsInSupplierTest extends SeleniumTestAbstract {


	/* Record detail page elements */
	

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keyword = "china";
	String dropdownoption_keywordsinSupplier = "Supplier";

	@Test
	public void loginwithComplexaction() {
		LoginPageUtil.login(userName, password);
		HomePageUtil.enterAdvancedSearchPage();
		AdvancedSearchPageUtil.search(keyword, dropdownoption_keywordsinSupplier);

		// advanced page input frame
		
		// counter the result and return counternumber
		int matchedCount = 0;
		int recordCount =SearchResultListPageUtil.getAllRecordLinks().size();

		for (int i = 0; i < recordCount; i++) {
			SearchResultListPageUtil.enterDetailedInfoPage(i);
			String str1 =DetailedInfoPageUtil.getMacthcedSupplieserwithChina();
			matchedCount = (str1.indexOf(keyword) >= 0 ? matchedCount + 1
					: matchedCount);

			SeleniumUtil.back();
			SeleniumUtil.waitForFixedMilliseconds(9000);
		}

		System.out.println("total find " + matchedCount
				+ " kind of book with series subject of " + keyword);
	}

	
}
