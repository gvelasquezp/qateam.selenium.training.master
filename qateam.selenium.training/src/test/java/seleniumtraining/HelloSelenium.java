package seleniumtraining;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloSelenium {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello Selenium");
	 	
		String driverPath = System.getProperty("user.dir")+ File.separator+ "drivers"+ File.separator+ "geckodriver"; // add .exe for windows
		System.setProperty("webdriver.gecko.driver", driverPath);
        //FirefoxDriver driver = new FirefoxDriver();
        WebDriver driver = new FirefoxDriver();
        Thread.sleep(5000);
        driver.quit();

	}

}
