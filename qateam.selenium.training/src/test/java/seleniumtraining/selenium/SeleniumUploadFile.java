package seleniumtraining.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;


public class SeleniumUploadFile {
	
	//Use https://the-internet.herokuapp.com/upload
	
	@Test
	public void testUploadFile() throws Exception {
		
		String driverPath = System.getProperty("user.dir")+ File.separator+ "drivers"+ File.separator+ "chromedriver"; // add .exe for windows
		System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement fileSubmitButton = driver.findElement(By.id("file-submit"));
		wait.until(d -> fileSubmitButton.isDisplayed());
		
		Path path = Paths.get("src/test/resources/selenium-screenshot.png");
	    File imagePath = new File(path.toUri());
	    
	    System.out.println("File path :" + imagePath.toString());
	    
	    WebElement fileUploadField = driver.findElement(By.id("file-upload"));
	    fileUploadField.sendKeys(imagePath.toString());
	    fileSubmitButton.submit();
	    
	    if(driver.getPageSource().contains("File Uploaded!")) {
	    	System.out.println("File uploaded");
	    }
	    else{
	        System.out.println("File not uploaded");
	    }
	    
		Thread.sleep(3000);
        driver.quit();
				
	}

}
