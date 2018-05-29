package TryJavaFeatures.TestReflect;

import java.util.ArrayList;
import java.util.List;

public class ReflectTest {
	public static void main(String args[]) throws Exception {
	
		int a[]= {1,2,3};
		int b[] = null;
		b[1]=a[1];
		b[1]=5;
		
		System.out.println(b);
		 
	}
	
}
	

