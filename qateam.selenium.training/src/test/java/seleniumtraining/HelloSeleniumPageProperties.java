package seleniumtraining;

import org.openqa.selenium.WebDriver;
import seleniumtraining.common.Configuration;

public class HelloSeleniumPageProperties {

	public static void main(String[] args) throws Exception {
		WebDriver driver = Configuration.createChromeDriver();
		driver.manage().window().maximize();
        driver.get(Configuration.BLOG_URL);
        Thread.sleep(3000);
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Page Source: " + driver.getPageSource());
        driver.quit();
	}

}
