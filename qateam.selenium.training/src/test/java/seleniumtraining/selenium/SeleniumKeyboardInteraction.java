package seleniumtraining.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seleniumtraining.common.BaseTestNew;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;


public class SeleniumKeyboardInteraction extends BaseTestNew{
	
	@Test
	public void testKeyboardInteraction() throws Exception {
		
		List<WebElement> menuItems = getDriver().findElements(By.className("oxd-main-menu-item-wrapper"));
		
		String itemExpected = "Admin";
		
		for(WebElement element: menuItems) {
			if(element.getText().equals(itemExpected)){
				element.click();
				break;
			}
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-input.oxd-input--active:not([placeholder])")));
		Thread.sleep(3000);
		
		String title = "guillermo";
		WebElement usernameField = driver.findElement(By.cssSelector(".oxd-input.oxd-input--active:not([placeholder])"));
		usernameField.sendKeys(Keys.chord(Keys.SHIFT, title));
		assertEquals(title.toUpperCase(), usernameField.getAttribute("value"), "Assert upper case title");
		
		Thread.sleep(3000);
		
	}
	
	@Test
	public void testKeyboardInteractionWithActions() throws Exception {
		
		List<WebElement> menuItems = getDriver().findElements(By.className("oxd-main-menu-item-wrapper"));
		
		String itemExpected = "Admin";
		
		for(WebElement element: menuItems) {
			if(element.getText().equals(itemExpected)){
				element.click();
				break;
			}
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-input.oxd-input--active:not([placeholder])")));
		Thread.sleep(3000);
		
		String title = "guillermo";
		WebElement usernameField = driver.findElement(By.cssSelector(".oxd-input.oxd-input--active:not([placeholder])"));

		Actions actions = new Actions(getDriver());
		actions.keyDown(Keys.SHIFT)
		.sendKeys(usernameField, title)
		.keyUp(Keys.SHIFT)
		.build()
		.perform();

		assertEquals(title.toUpperCase(), usernameField.getAttribute("value"), "Assert upper case title");
		
		Thread.sleep(3000);
		
	}

}
