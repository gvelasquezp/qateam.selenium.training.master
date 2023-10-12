package seleniumtraining.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import seleniumtraining.common.BaseTest;
import seleniumtraining.common.Configuration;

import java.time.Duration;

public class SeleniumExplicitWait extends BaseTest{
	
	
	
	@Test
	public void testExplicitWait() throws Exception {
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement userTextBox = driver.findElement(By.name("username"));
		wait.until(d -> userTextBox.isEnabled());
        userTextBox.sendKeys(Configuration.USER_NAME);
        WebElement pwdTextBox = driver.findElement(By.name("password"));
        wait.until(d -> pwdTextBox.isEnabled());
        pwdTextBox.sendKeys(Configuration.PASSWORD);
        pwdTextBox.submit();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-main-menu")));
        WebElement menuLoaded = driver.findElement(By.cssSelector("div.oxd-main-menu"));
        boolean loggedIn = menuLoaded.isDisplayed();
        assertTrue(loggedIn, "Assert that menu is loaded.");

        // Logout
        driver.findElement(By.cssSelector(".oxd-userdropdown-tab")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement userTextBoxLogout = driver.findElement(By.name("username"));
		assertTrue(userTextBoxLogout.isDisplayed(), "Assert successful logout.");

	}

}
