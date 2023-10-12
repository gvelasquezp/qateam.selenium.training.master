package seleniumtraining.common;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Configuration {
	
	///PRIMER BLOQUE
	
	public static String DRIVER_DIR = System.getProperty("user.dir")+File.separator+"drivers"+File.separator;
			
	public static String CHROME_DRIVER_PATH = DRIVER_DIR + "chromedriver";
	public static String GECKO_DRIVER_PATH = DRIVER_DIR + "geckodriver";
	
	public static String BLOG_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	//public static String BLOG_URL = "https://automationexercise.com/";
	//public static String BLOG_URL = "https://demo.guru99.com/test/newtours/register.php";
	
	public static String USER_NAME = "Admin";
	public static String PASSWORD = "admin123";
	
	public static String SCREENSHOTS_DIR = System.getProperty("user.dir") 
			+ File.separator
			+ "screenshots"
			+ File.separator;
	
	private static String modifyIfWindows(String inPath) {
		if (System.getProperty("os.name").toLowerCase().contains("windows")){
			return inPath + ".exe";
		} else {
			return inPath;
		}
	}
	
	public static WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver", modifyIfWindows(CHROME_DRIVER_PATH));
		return new ChromeDriver();
	}
	
	public static WebDriver createFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", modifyIfWindows(GECKO_DRIVER_PATH));
		return new FirefoxDriver();
	}

}
