package classLoader;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.jar.Attributes.Name;

public class java8foreach {

	public static void main(String args[]) {
//http://somefuture.iteye.com/blog/2032141
		final List<String> friends =
				Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		/*for(int i=0;i<friends.size();i++)		
		
		System.out.println(friends.get(i));
		*/

		/*for (String name : friends) {
			System.out.println(name);

		}*/
		
	/*	friends.forEach(new Consumer<String>() {
			public void accept(final String name) {
				System.out.println(name);
			}
		});
		*/
		
		
	/*	friends.forEach((final String name) -> System.out.println(name));*/
		
		
		/*ambda表达式的标准语法，是把参数放到（）里面，提供类型信息并使用逗号分隔参数。
		 * Java编译器为了解放我们，还能自动进行类型推导。
		 * 不写类型当然更方便了，工作少了，世界也清静了。下面是上一个版本去掉了参数类型之后的：
		 * 
		 * friends.forEach((mmmm) -> System.out.println(mmmm));
		 * */
		
		/*Java编译器对单个参数的lambda表达式会进行特殊处理：
		 * 如果你想进行类型推导的话，参数两边的括号可以省略掉。*/

		friends.forEach(Name -> {
			System.out.println(Name);
			System.out.println("hello");
			
		});

		//friends.forEach(System.out::println);
		
	}}
	

