package debug.optimize.level2extractSeleniumApi.cases;

import org.junit.Test;

import debug.optimize.level2extractSeleniumApi.framework.SeleniumTestAbstract;
import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class QuickTest extends SeleniumTestAbstract {

	@Test
	public void learnAssertPass() {
		SeleniumUtil.get("http://www.baidu.com");
		SeleniumUtil.assertTrue("On baidu home page, the expected text [hao123] was not displayed. ", 
			SeleniumUtil.getBodyText().indexOf("hao123") >= 0);
	}
	
	@Test
	public void learnAssertFail() {
		SeleniumUtil.get("http://www.baidu.com");
		SeleniumUtil.assertTrue("On baidu home page, the expected text [JetFire] was not displayed. ", 
			SeleniumUtil.getBodyText().indexOf("JetFire") >= 0);
	}
	
	@Test
	public void learnAssertFailWithoutMessage() {
		SeleniumUtil.get("http://www.baidu.com");
		SeleniumUtil.assertTrue(SeleniumUtil.getBodyText().indexOf("JetFire") >= 0);
	}
	
	@Test
	public void learnAssertEqualsFail() {
		SeleniumUtil.assertEquals("1", "2");
	}
	
	
}
