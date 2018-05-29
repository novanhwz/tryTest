package TryJavaFeatures;


import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AssertThasHasProperty {
	private User user1;
    private User user2;
    private Card card1;
    private Card card2;
    
    @Before
    public void init(){
            user1 = new User();
            user1.setUserName("lily");
            user1.setPassword("123");
            user1.setMoney(500.0);
           
            
            user2 = new User();
            user2.setUserName("lucy");
            user2.setPassword("321");
            user1.setMoney(800.0);
            
            card1.setBank("icbc");
            
            card2.setAmmount(600.0);
            card2.setBank("HBC");
            
            List<User> testList = new ArrayList<User>();
            testList.add(user1);
            testList.add(user2);
            List<Card> cardList = new ArrayList<Card>();
            cardList.add(card1);
            cardList.add(card2);
            
            
            
    }
    @Test
	public void tryHasProperty(){
		
    	/* String[] words = {"ace", "boom", "crew", "dog", "eon"};  
    	  
         List<String> wordList = Arrays.asList(words);  
         //wordList.add("1");  
         for (String e : wordList){  
             System.out.println(e);  
         }  */
    	
    	List<String> list = Arrays.asList("hi", "ni", "hao");
    	//assertThat(list, contains("ni"));
		
	}
	
}
