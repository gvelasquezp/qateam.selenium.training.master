package seleniumtraining.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;


public class SeleniumJSExecution{
	
	@Test
	public void testJSExecution() throws Exception {
		
		String driverPath = System.getProperty("user.dir")+ File.separator+ "drivers"+ File.separator+ "chromedriver"; // add .exe for windows
		System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().window().maximize();
        
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        
        jsExec.executeScript("document.getElementsByName('firstName')[0].value='Guillermo'");
        jsExec.executeScript("document.getElementsByName('lastName')[0].value='Velasquez'");
        jsExec.executeScript("document.getElementsByName('phone')[0].value='982739314'");
        jsExec.executeScript("document.getElementsByName('userName')[0].value='guillermo@email.com'");
        jsExec.executeScript("document.getElementsByName('address1')[0].value='Buenavista 762'");
        jsExec.executeScript("document.getElementsByName('city')[0].value='Lima'");
        jsExec.executeScript("document.getElementsByName('state')[0].value='Lima'");
        jsExec.executeScript("document.getElementsByName('postalCode')[0].value='Lima01'");

        driver.findElement(By.name("country")).click();
        driver.findElement(By.cssSelector("[value='ALGERIA']")).click();
        
        jsExec.executeScript("document.getElementsByName('email')[0].value='guillermo@email.com'");
        jsExec.executeScript("document.getElementsByName('password')[0].value='password'");
        jsExec.executeScript("document.getElementsByName('confirmPassword')[0].value='password'");
        
        WebElement submit = driver.findElement(By.name("submit"));
		
		jsExec.executeScript("arguments[0].click();", submit);
        
        Thread.sleep(3000);
        driver.quit();
        
    }

}
