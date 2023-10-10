package seleniumtraining;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumChrome {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello Selenium");
	 	
		String driverPath = System.getProperty("user.dir")+ File.separator+ "drivers"+ File.separator+ "chromedriver"; // add .exe for windows
		System.setProperty("webdriver.chrome.driver", driverPath);
        //ChromeDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.quit();

	}

}
