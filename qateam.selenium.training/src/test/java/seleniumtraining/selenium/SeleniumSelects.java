package seleniumtraining.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.time.Duration;

public class SeleniumSelects{
	
 //Use https://demo.guru99.com/test/newtours/register.php
	
	
	@Test
	public void testSelectWithClicks() throws Exception {
		
		String driverPath = System.getProperty("user.dir")+ File.separator+ "drivers"+ File.separator+ "chromedriver"; // add .exe for windows
		System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().window().maximize();
        
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement countryDropdown = driver.findElement(By.name("country"));
		wait.until(d -> countryDropdown.isDisplayed());
		countryDropdown.click();
		
		WebElement optionToSelect = driver.findElement(By.cssSelector("[value='ALGERIA']"));
		optionToSelect.click();
		countryDropdown.click();
        
        Thread.sleep(5000);
        driver.quit();
		
	}
	
	@Test
	public void testSelectElement() throws Exception {
		
		String driverPath = System.getProperty("user.dir")+ File.separator+ "drivers"+ File.separator+ "chromedriver"; // add .exe for windows
		System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().window().maximize();
        
        String country = "ANGOLA";
        Select countryList = new Select(driver.findElement(By.name("country")));
        countryList.selectByIndex(5);
        Thread.sleep(3000);
        countryList.selectByVisibleText("ANDORRA");
        Thread.sleep(3000);
        countryList.selectByValue(country);
        
        String actualCountry = countryList.getFirstSelectedOption().getText();
		assertEquals(country, actualCountry, "Verifying Selected Country");
        
        Thread.sleep(3000);
        driver.quit();
		
	}

}
