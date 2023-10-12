package seleniumtraining.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import seleniumtraining.common.SeleniumUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SeleniumHeadlessBrowser {
	
	@Test
	public void testHeadlessBrowser() throws Exception {
		
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println(driver.getPageSource());
		
		WebElement firstNameField = driver.findElement(By.name("firstName"));
		SeleniumUtils.printElementInfo("First Name text box", firstNameField);
		firstNameField.sendKeys("Guillermo");
		
		WebElement lastNameField = driver.findElement(By.name("lastName"));
		SeleniumUtils.printElementInfo("Last Name text box", lastNameField);
		lastNameField.sendKeys("Velasquez");
		
		System.out.println("Page title is : " + driver.getTitle());
		System.out.println("First Name : " + firstNameField.getAttribute("value"));
		System.out.println("Last Name : " + lastNameField.getAttribute("value"));
		       
		assertEquals("Guillermo", firstNameField.getAttribute("value"));
		assertEquals("Velasquez", lastNameField.getAttribute("value"));
		driver.quit();
		
    }

}
