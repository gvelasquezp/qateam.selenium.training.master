package seleniumtraining.common;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {
	
	protected static WebDriver driver = null;
	
	@BeforeAll
	public static void launchBrowser() throws Exception {
        driver = Configuration.createChromeDriver();	
        driver.get(Configuration.BLOG_URL);
        Thread.sleep(4000);
	}

	@AfterAll
	public static void closeBrowser() {
        driver.quit();		
	}

}
