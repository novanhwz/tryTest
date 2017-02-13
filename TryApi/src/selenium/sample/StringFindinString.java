package selenium.sample;

public class StringFindinString {

	public static void main(String[] args) {
		

        String str1 = "i am late for work i i am late for work i";
        String str2="work";
int counter=0;
        if (str1.indexOf(str2) == -1) {
counter = counter+ 0;
        } else if (str1.indexOf(str2) != -1) {
            counter++;
            str1=str1.substring(str1.indexOf("work")+4);
            
            // stringNumbers(str.substring(str.indexOf("java")+4)); 
            
        }
System.out.println("we get counter number is"+counter);
    
	}

}
