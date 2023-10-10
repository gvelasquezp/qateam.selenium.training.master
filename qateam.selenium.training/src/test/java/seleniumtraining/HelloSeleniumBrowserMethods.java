package seleniumtraining;

import org.openqa.selenium.WebDriver;
import seleniumtraining.common.Configuration;

public class HelloSeleniumBrowserMethods {

	public static void main(String[] args) throws Exception {
		WebDriver driver = Configuration.createChromeDriver();
		driver.manage().window().maximize();
        driver.get(Configuration.BLOG_URL);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        
        System.out.println("Window Handle: " + driver.getWindowHandle());
        
        for (String win: driver.getWindowHandles()){
                System.out.println("H: " + win);
        }
        driver.quit();
	}

}
