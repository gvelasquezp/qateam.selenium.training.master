package seleniumtraining.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import seleniumtraining.common.BaseTestNew;
import seleniumtraining.common.Configuration;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SeleniumHandlingWindows extends BaseTestNew{
	
	@Test
	public void testHandlingWindows() throws Exception {
		
		System.out.println("Initial windows title : "+getDriver().getTitle());
        String mainWin = getDriver().getWindowHandle();
        System.out.println("Current windows id : "+mainWin);
        
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.open(arguments[0]);", Configuration.BLOG_URL);
        Thread.sleep(5000);
        
        
        for (String handle: getDriver().getWindowHandles()) {
            if (!handle.equals(mainWin)) {
                getDriver().switchTo().window(handle);
                System.out.println(getDriver().getTitle());
                getDriver().close();
            }
        }
        
        getDriver().switchTo().window(mainWin);
        System.out.println("Final windows title : " + getDriver().getTitle());
        
        // Assert that the new window was closed
        assertEquals(getDriver().getWindowHandles().size(), 1, "Verifying whether new window is closed");
        
    }

}
