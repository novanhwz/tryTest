package classLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.jar.Attributes.Name;


public class CollectionContainsCollection {

	public static void main(String args[]) {
		
		List<String> listA = new ArrayList<String>();
		listA.add("hello");
		listA.add("hi");
		listA.add("Bonjure");
		
		List<String> listB = new ArrayList<String>();
		listB.add("hello");
		listB.add("hi");
		
		List<String> listC = new ArrayList<String>();
		listC.add("hello");
		listC.add("hi");
		listC.add("NIHAO");
		
		String aaaa = "hello";
		
		System.out.println("listA containsAll listB:  "+ listA.containsAll(listB));
		System.out.println("listA contains listB:  "+ listA.contains(listB));
		System.out.println("listA containsAll listC:  "+ listA.containsAll(listC));
		System.out.println("listA containsAll aaaa:  "+ listA.contains(aaaa));
		
	}
	}
	

