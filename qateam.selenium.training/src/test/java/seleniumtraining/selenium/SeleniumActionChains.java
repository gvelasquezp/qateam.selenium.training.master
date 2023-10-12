package seleniumtraining.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;


public class SeleniumActionChains {
	
	@Test
	public void testActionChains() throws Exception {
		
		String driverPath = System.getProperty("user.dir")+ File.separator+ "drivers"+ File.separator+ "chromedriver"; // add .exe for windows
		System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/menu/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        
        WebElement menuBar = driver.findElement(By.xpath(".//a[contains(text(),'Main Item 2')]/.."));
        
        Actions builder = new Actions(driver);
        builder.moveToElement(menuBar)
        .pause(1000)
        .moveToElement(driver.findElement(By.xpath(".//a[contains(text(),'SUB SUB LIST')]/..")));
		
		// Build composite action.
		Action compAction = builder.build();
		
		// Perform Action (Till this 
		compAction.perform();

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[contains(text(),'Sub Sub Item 1')]/..")));
        
        Thread.sleep(3000);
        driver.quit();
		
    }

}
