package selenium.api;

import org.junit.Test;

public class WindowHandleSwitchToNewWindow {
	/*
	@Test
	  public static void clickAndSwitchToNewWindow( By by, int windowPromptedOutTimeout) {
        Set<String> before = SeleniumUtil.getWindowHandles();
        SeleniumUtil.click(by);
        SeleniumUtil.switchToPromptedWindow(before, windowPromptedOutTimeout);
   }

   public static String switchToPromptedWindow(Set<String> before, long waitForMilliseconds){
        return switchToPromptedWindow(before, waitForMilliseconds, "new");
   }
  
        *//**
   * switch to prompted window after wait for some milliseconds
   * *//*
   public static String switchToPromptedWindow(Set<String> before, long waitForMilliseconds,
             String expectedWindowName){
        String foundNewWindow = getPromptedWindow(before, waitForMilliseconds);
        if(foundNewWindow != null){
             String oldWin = SeleniumUtil.getWindowHandle();
             SeleniumUtil.switchToWindow(foundNewWindow);
             return oldWin;
        }
        throw new AssertionError("Time out waiting for " + expectedWindowName + " window to prompted "
             + "out within " + (waitForMilliseconds/1000) + " seconds. ");
   }
  
   public static String switchToPromptedWindow(Set<String> before, long waitForMilliseconds){
        return switchToPromptedWindow(before, waitForMilliseconds, "new");
   }
  
   public static String getPromptedWindow(Set<String> before, long waitForMilliseconds){
        final long oneRoundWait = 500;
        final long deadLine = System.currentTimeMillis() + waitForMilliseconds;
       
        String foundNewWindow = null;
        while(true){
             List<String> after = new ArrayList<String>(SeleniumUtil.getWindowHandles());
             after.removeAll(before);
             if(after.size() > 0){
                  foundNewWindow = after.get(0);
                  return foundNewWindow;
             }
            
             SeleniumUtil.waitForFixedMilliseconds(oneRoundWait);
             if(System.currentTimeMillis() > deadLine){
                  return null;
             }
        }

*/
}
