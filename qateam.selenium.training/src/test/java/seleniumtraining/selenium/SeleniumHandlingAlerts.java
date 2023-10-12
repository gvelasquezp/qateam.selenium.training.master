package seleniumtraining.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.Duration;


public class SeleniumHandlingAlerts {
	
	@Test
	public void testHandlingAlerts() throws Exception {
		
		String driverPath = System.getProperty("user.dir")+ File.separator+ "drivers"+ File.separator+ "chromedriver"; // add .exe for windows
		System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement alertForm = driver.findElement(By.id("javascriptAlertsWrapper"));
		wait.until(d -> alertForm.isDisplayed());
		
		String alertText = "This is an alert";
		        
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		WebElement alertResult = driver.findElement(By.id("confirmResult"));
		System.out.println("Result : "+alertResult.getText());
		assertTrue(alertResult.getText().contains("Cancel"));

		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys(alertText);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		WebElement promptResult = driver.findElement(By.id("promptResult"));
		System.out.println("Prompt Result : "+promptResult.getText());
		assertTrue(promptResult.getText().contains(alertText));
        
        Thread.sleep(3000);
        driver.quit();
		
    }

}
