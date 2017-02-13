package classLoader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.jar.Attributes.Name;

import java_cup.runtime.virtual_parse_stack;

public class java8MapBianli {

	public static void main(String args[]) {

	Map<String, Integer> items = new HashMap<>();
	items.put("A", 10);
	items.put("B", 20);
	items.put("C", 30);
	items.put("C", 30);
	items.put("D", 40);
	items.put("E", 50);
	items.put("F", 60);
	System.out.println(items.get("F")); 
	items.forEach((k,v)->System.out.println("key"+k+"value"+v));
	
			}
	}
	

