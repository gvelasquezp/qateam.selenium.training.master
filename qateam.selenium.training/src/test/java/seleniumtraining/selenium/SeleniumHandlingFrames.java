package seleniumtraining.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.time.Duration;


public class SeleniumHandlingFrames {
	
	@Test
	public void testHandlingFrames() throws Exception {
		
		String driverPath = System.getProperty("user.dir")+ File.separator+ "drivers"+ File.separator+ "chromedriver"; // add .exe for windows
		System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();
        
        String expectedDescription = "This is a sample page";
        
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement pageDescription = driver.findElement(By.cssSelector("div[id='framesWrapper']>div:not([id])"));
		wait.until(d -> pageDescription.isDisplayed());
		
		driver.switchTo().frame("frame1");
		WebElement firstFrameDescription = driver.findElement(By.tagName("h1"));
		System.out.println("First Frame description : "+firstFrameDescription.getText());
		assertEquals(expectedDescription, firstFrameDescription.getText(), "Assert frame description");
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		WebElement secondFrameDescription = driver.findElement(By.tagName("h1"));
		System.out.println("Second Frame description : "+secondFrameDescription.getText());
		assertEquals(expectedDescription, secondFrameDescription.getText(), "Assert frame description");
		
		driver.switchTo().defaultContent();
        
        Thread.sleep(3000);
        driver.quit();
		
    }

}
