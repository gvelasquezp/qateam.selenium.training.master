package seleniumtraining.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumtraining.common.BaseTest;
import seleniumtraining.common.Configuration;

import java.time.Duration;

public class SeleniumImplicitWait extends BaseTest{
	
	@Test
	public void testImplicitWait() throws Exception {
		
        WebElement userTextBox = driver.findElement(By.name("username"));
        userTextBox.sendKeys(Configuration.USER_NAME);
        WebElement pwdTextBox = driver.findElement(By.name("password"));
        pwdTextBox.sendKeys(Configuration.PASSWORD);
        pwdTextBox.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        boolean menuLoaded = driver.findElement(By.cssSelector("div.oxd-main-menu")).isDisplayed();
        assertTrue(menuLoaded, "Assert that menu is loaded.");

        // Logout
        driver.findElement(By.cssSelector(".oxd-userdropdown-tab")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement userTextBoxLogout = driver.findElement(By.name("username"));
		assertTrue(userTextBoxLogout.isDisplayed(), "Assert successful logout.");

	}

}
