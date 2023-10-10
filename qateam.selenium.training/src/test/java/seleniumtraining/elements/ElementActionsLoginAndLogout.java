package seleniumtraining.elements;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumtraining.common.BaseTest;
import seleniumtraining.common.Configuration;

public class ElementActionsLoginAndLogout extends BaseTest{
	
	@Test
	public void test() throws Exception {
		
        WebElement userTextBox = driver.findElement(By.name("username"));
        userTextBox.sendKeys(Configuration.USER_NAME);
        WebElement pwdTextBox = driver.findElement(By.name("password"));
        pwdTextBox.sendKeys(Configuration.PASSWORD);
        pwdTextBox.submit();
        Thread.sleep(2000);
        boolean menuLoaded = driver.findElement(By.cssSelector("div.oxd-main-menu")).isDisplayed();
        assertTrue(menuLoaded, "Assert that menu is loaded.");

        // Logout
        driver.findElement(By.cssSelector(".oxd-userdropdown-tab")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
		Thread.sleep(1000);
		assertTrue(userTextBox.isDisplayed(), "Assert successful logout.");

	}

}
