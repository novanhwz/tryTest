package selenium.api;

import org.junit.Test;

public class TrimString {
	
	@Test
	public void openConcurrentPage() {
		String str1="        Enduser:---- Any ----                    ";
		String a=str1.trim();
		System.out.println(a);
		System.out.println(a);
		System.out.print("a");
		System.out.print("a2");
}

}
