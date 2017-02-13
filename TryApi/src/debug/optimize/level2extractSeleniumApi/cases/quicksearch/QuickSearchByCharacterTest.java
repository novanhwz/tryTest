package debug.optimize.level2extractSeleniumApi.cases.quicksearch;

import org.junit.Test;
import debug.optimize.level2extractSeleniumApi.framework.SeleniumTestAbstract;
import debug.optimize.level2extractSeleniumApi.pages.DetailedInfoPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.HomePageUtil;
import debug.optimize.level2extractSeleniumApi.pages.LoginPageUtil;
import debug.optimize.level2extractSeleniumApi.pages.SearchResultListPageUtil;
import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class QuickSearchByCharacterTest extends SeleniumTestAbstract {

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keyword = "china";

	@Test
	public void loginwithComplexaction() {
		LoginPageUtil.login(userName, password);
		HomePageUtil.searchByCharacter(keyword);

		int matchedCount = 0;
		int recordCount =SearchResultListPageUtil.getRecordCountNeedGotoDetailedPage();

		for (int i = 0; i < recordCount; i++) {
			SearchResultListPageUtil.enterDetailedInfoPage(i);
			String str1 = DetailedInfoPageUtil.getMacthcedCharacterwithChina();
			matchedCount = (str1.indexOf(keyword) >= 0 ? matchedCount + 1
					: matchedCount);

			SeleniumUtil.back();
			SeleniumUtil.waitForFixedMilliseconds(9000);
		}

		System.out.println("totoal find " + matchedCount
				+ " kind of book with Charactor China");
	}

}
