package seleniumtraining.elements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumtraining.common.BaseTest;
import seleniumtraining.common.Configuration;

public class ElementActionsEnterAndVerifyText extends BaseTest{
	
	@Test
	void enterUserName() throws Exception{
        String expectedUserName = Configuration.USER_NAME;
        WebElement userTextBox = driver.findElement(By.name("username"));
        assertTrue(userTextBox.isEnabled(), "Assert that user name text box is enabled.");
        userTextBox.sendKeys(expectedUserName);
        String actualUserName = userTextBox.getAttribute("value");
        System.out.println("Username value : "+actualUserName);
        assertEquals(expectedUserName, actualUserName, "Assert that user name is entered correctly");
	}

}
