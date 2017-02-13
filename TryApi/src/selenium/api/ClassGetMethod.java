package selenium.api;

import org.junit.Test;

public class ClassGetMethod {
	@Test
	public void getClassMethod() {

		Class<? extends ClassGetMethod> i = getClass();
		System.out.println(i);

		String str2 = getClass().getName();
		System.out.println(str2);

		Class<? extends Class> str3 = getClass().getClass();
		System.out.print(str3);

	}

}
