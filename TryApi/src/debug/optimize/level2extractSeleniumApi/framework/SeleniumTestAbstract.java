/*
 * History
 * Date        Ver Author        Change Description
 * ----------- --- ------------- ----------------------------------------
 * 18 Jun 2015 001 XX            Creates
 */
package debug.optimize.level2extractSeleniumApi.framework;

import org.junit.After;
import org.junit.Before;

import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class SeleniumTestAbstract {
	
	@Before
	public void setup() {
		SeleniumUtil.openFirefox();
	}
	
	@After
	public void tearDown() {
		SeleniumUtil.closeBrowser();
	}
	
}
