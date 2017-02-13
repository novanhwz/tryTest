package selenium.api;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class alertHandle {
	

	@Test
	public void handleAlert() {

		SeleniumUtil.openFirefox();
		SeleniumUtil.get("http://www.w3school.com.cn/tiy/t.asp?f=hdom_alert");
		SeleniumUtil.waitForFixedMilliseconds(5000);
		
		SeleniumUtil.switchToFrame("i");
		
		By displayAlertButton = By.xpath("//input");
		SeleniumUtil.click(displayAlertButton );
		
		Alert alert = SeleniumUtil.switchToAlert();
		SeleniumUtil.waitForFixedMilliseconds(5000);
		alert.accept();
		
		SeleniumUtil.quit();
	}

}
