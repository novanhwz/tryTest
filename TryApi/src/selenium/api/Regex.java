package selenium.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Regex {
@Test

	public void getregex(){
		   String regex = "([\\w]+(\\'|\\-)*[\\w]+)|([\\w]+)";
		      Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		 String article="He's a boy.And she has a low-income.";
		 Matcher matcher=pattern.matcher(article);
		 while (matcher.find()) {
		 System.out.println(matcher.group());
		 }
		 }
	
}
