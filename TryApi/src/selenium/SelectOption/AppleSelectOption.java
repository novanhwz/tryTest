package selenium.SelectOption;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AppleSelectOption {

	@Test
	public void selectAppleSecurity() {

		WebDriver dr = new FirefoxDriver();
		dr.get("https://appleid.apple.com/cgi-bin/WebObjects/MyAppleId.woa/wa/createAppleId");

		// 通过下拉列表中选项的索引选中第二项，
		// 即What is the first name of your best friend in high school?
		Select sq1 = new Select(dr.findElement(By.id("sec-q-1")));
		sq1.selectByIndex(2);

	}

}
