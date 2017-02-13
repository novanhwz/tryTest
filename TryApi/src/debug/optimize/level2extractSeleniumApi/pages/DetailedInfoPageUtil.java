package debug.optimize.level2extractSeleniumApi.pages;

import org.openqa.selenium.By;

import debug.optimize.level2extractSeleniumApi.util.SeleniumUtil;

public class DetailedInfoPageUtil {
	
	public static By RD_SPAN_FIRST_MATCHED_AUTHOR_WITH_CHINA = By.xpath("(//a[contains(text(),'China')])[1]");
	public static By RD_SPAN_FIRST_MATCHED_CHARACTER_WITH_CHINA = By.xpath("//span[contains(text(),' Character')]/../following-sibling::div/span");
	public static By RD_SPAN_FIRST_MATCHED_PUBLISHER_WITH_CHINA = By.xpath("(//span[contains(text(),'Publisher')])[1]/../following-sibling::div/span/a[1]");
	public static By RD_SPAN_FIRST_MATCHED_SUBJECT = By.xpath("//*[contains(text(),'Sears Subject')]/../following-sibling::div/span/a[1]");
	public static By RD_SPAN_FIRST_MATCHED_SUPPLISHER = By.xpath(".//*[contains(text(),'Price')]/../following-sibling::div/span/div");
	
	public static String getMacthcedAuthorwithChina(){
		String str1 = SeleniumUtil.getText( RD_SPAN_FIRST_MATCHED_AUTHOR_WITH_CHINA);
		str1 = str1.toLowerCase();
		System.out.println(str1);
		return str1;	
	}
	
	public static String getMacthcedCharacterwithChina(){
		String str1 = SeleniumUtil.getText( RD_SPAN_FIRST_MATCHED_CHARACTER_WITH_CHINA);
		str1 = str1.toLowerCase();
		System.out.println(str1);
		return str1;	
	}
	
	public static String getMacthcedPublisherwithChina(){
		String str1 = SeleniumUtil.getText(RD_SPAN_FIRST_MATCHED_PUBLISHER_WITH_CHINA);
		str1 = str1.toLowerCase();
		System.out.println(str1);
		return str1;	
	}
	
	public static String getMacthcedSubjectwithChina(){
		String str1 = SeleniumUtil.getText(RD_SPAN_FIRST_MATCHED_SUBJECT);
		str1 = str1.toLowerCase();
		System.out.println(str1);
		return str1;	
	}
	
	public static String getMacthcedSupplieserwithChina(){
		String str1 = SeleniumUtil.getText(RD_SPAN_FIRST_MATCHED_SUPPLISHER);
		str1 = str1.toLowerCase();
		System.out.println(str1);
		return str1;	
	}

}
