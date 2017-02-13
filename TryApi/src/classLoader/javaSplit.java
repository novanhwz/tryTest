package classLoader;

public class javaSplit {

	public static void main(String args[]) {

		/*String address = new String("192^168@13#240");
		String[] str = address.split("\\^|@|#");
		for (String s : str) {
			System.out.println(s);*/
			
			
		/*	
			String[] aa = "aaa|bbb|ccc".split("|");

		    //String[] aa = "aaa|bbb|ccc".split("\\|");

		    for (int i = 0 ; i <aa.length ; i++ ) {

		      System.out.println("--"+aa[i]); 

		    }*/
		
		
		String str="5678|XYZ";  
		String[] b = str.split("\\|");  //注意直接使用|，该字符是正则表达式的一部分，  
		int length = b.length;
		System.out.println("length:"+length);
		String x="result: ";  
		for(int i=0;i<b.length;i++){  
		    x=x+b[i]+",";  
		    System.out.println(x);
		}  
		System.out.println(x);   //输出的是: 处理结果: 5,6,7,8,|,X,Y,Z,  
		}
	}

