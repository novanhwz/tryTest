package debug.optimize.level2extractSeleniumApi.cases.quicksearch;

import org.junit.Test;
import org.openqa.selenium.By;

import debug.optimize.level2extractSeleniumApi.pages.HomePageUtil;
import debug.optimize.level2extractSeleniumApi.pages.LoginPageUtil;
import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;


public class QuckSearchByTitleTest {
	
	/* Result list page elements */
	By RL_LINK_RECORD_LINKS = By.xpath("//a[contains(@class, 'classiclink notranslate')]");
	
	/* Record detail page elements */
	By RD_SPAN_FIRST_MATCHED_SUBJECT = By.xpath("//span[contains(text(),'China')]");

	// Test data
	String userName = "SelAdmin";
	String password = "12345678";
	String keyword = "china";

	@Test
	public void loginwithComplexaction(){
		LoginPageUtil.login(userName, password);
        HomePageUtil.searchByTitle(keyword);
    
        int matchedCount = 0;
        int recordCount = SeleniumUtil.getRecordCount(RL_LINK_RECORD_LINKS);
        
        for (int i = 0; i < recordCount; i++) {
        	String str1 = enterRecordAndGetFirstSubject(i);                       
            matchedCount = (str1.indexOf(keyword)>=0 ? matchedCount + 1 : matchedCount);
            
            SeleniumUtil.back();
            SeleniumUtil.waitForFixedMilliseconds(9000);
		}
        
        System.out.println("totoal find "+matchedCount+" kind of book with charactor China");
	}

	private String enterRecordAndGetFirstSubject(int i) {
		By currentRecordLinkBy = By.xpath("(//*[@id='resulttable']/tbody/tr/td[3]/div/h5/a)[" + (i+1) + "]");
		SeleniumUtil.click(currentRecordLinkBy);
		SeleniumUtil.waitForFixedMilliseconds(8000);
		
		String str1=SeleniumUtil.getText(RD_SPAN_FIRST_MATCHED_SUBJECT);
		str1=str1.toLowerCase();
		System.out.println(str1);
		return str1;
	}
		
}
