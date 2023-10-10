package seleniumtraining;

import org.openqa.selenium.WebDriver;
import seleniumtraining.common.Configuration;

public class HelloSeleniumBrowser {

	public static void main(String[] args) throws Exception {
		WebDriver driver = Configuration.createChromeDriver();
		//WebDriver driver = Configuration.createFireFoxDriver();
        Thread.sleep(5000);
        driver.quit();
	}

}
