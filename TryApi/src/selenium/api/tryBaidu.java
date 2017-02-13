package selenium.api;

import org.junit.Test;
import org.openqa.selenium.By;

import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class tryBaidu {
	
	@Test
	public void to() {
		By input= By.id("kw");
		By search=By.id("su");
		By a=By.xpath("//a[@target='_blank']");
		SeleniumUtil.openFirefox();
		SeleniumUtil.get("www.baidu.com");
		SeleniumUtil.sendKeys(input, "boyankeji");
		SeleniumUtil.click(search);
		SeleniumUtil.findElements(a).get(0).click();
		
		
		
		
	}

}
