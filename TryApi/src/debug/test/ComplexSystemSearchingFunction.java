package debug.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ComplexSystemSearchingFunction {
	
	@Test
	public void loginwithComplexaction(){
		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		WebDriver driver=new FirefoxDriver(profile);
		driver.manage().window().maximize();
		
		driver.get("http://aws.preprod.booksinprint.com/");
		WebElement element1 = driver.findElement(By.id("loginID"));
		clearSendKeys(element1, "SelAdmin");
		waitForFixedMilliseconds(500);
		
		WebElement element2 = driver.findElement(By.id("password"));
		clearSendKeys(element2, "12345678");
		waitForFixedMilliseconds(500);
		
		driver.findElement(By.xpath("//*[@id='loginForm']/div[5]/div[2]/input"))
				.click();
		
		// NOTE: wait for login
		waitForFixedMilliseconds(7000);

        // 先定位下拉菜单
        driver.findElement(By.id("selectedVal")).click();
        // 然后定位到下拉菜单中的其中一个选项，最后click
        driver.findElement(By.id("selectedVal"))
                .findElement(By.xpath("//*[@id='searchTypeUl']/li[2]")).click();
        WebElement e3 = driver.findElement(By.id("txtSearch"));
        e3.sendKeys("china");
        driver.findElement(By.id("searchButtonGO")).click();
        
        // NOTE: wait after search result is displayed
        waitForFixedMilliseconds(5000);
    
        int counter=0;
        By linkBys = By.xpath("//*[@id='resulttable']/tbody/tr/td[3]/div/h5/a");
        int recordCount = driver.findElements(linkBys).size();
        
        // There is a bug here
        for (int i = 0; i < recordCount; i++) {
        	
        	By linkBy = By.xpath("(//*[@id='resulttable']/tbody/tr/td[3]/div/h5/a)[" + (i+1) + "]");
        	WebElement currentLink = driver.findElement(linkBy);
        	currentLink.click();
        	waitForFixedMilliseconds(6000);
        	
            WebElement elementchina=driver.findElement(By.xpath("//*[@id='content_overview']/div"));
            String str1=elementchina.getText();
            str1=str1.toLowerCase();
            System.out.println(str1);                       
            if (str1.indexOf("china")>=0) {
                counter++;                
                												
                //返回上一頁
                driver.navigate().back();
                //driver.findElement(By.id("buttonbacktoresults")).click();
                waitForFixedMilliseconds(5000);
            } else {
                //driver.findElement(By.id("buttonbacktoresults")).click();
                driver.navigate().back(); 
                waitForFixedMilliseconds(5000);
            }
           
		}
        System.out.println("totoal find "+counter+" kind of book with charactor China");
        
        driver.quit();

	}

	private void clearSendKeys(WebElement element1, String value) {
		element1.clear();
		element1.sendKeys(value);
	}

	private void waitForFixedMilliseconds(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) { }
	}
	
	
	
}
