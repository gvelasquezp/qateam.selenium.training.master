package seleniumtraining.selenium;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seleniumtraining.common.BaseTestNew;
import java.util.List;

public class SeleniumMultiElements extends BaseTestNew{
	
	@Test
	public void testMultiElements() throws Exception {
		
		List<WebElement> menuItems = getDriver().findElements(By.className("oxd-main-menu-item-wrapper"));
		
		System.out.println("Menu items count:" + menuItems.size());
		
		String itemExpected = "Buzz";
		
		for(WebElement element: menuItems) {
			System.out.println("Menu item label:" + element.getText());
			if(element.getText().equals(itemExpected)) element.click();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-buzz-newsfeed")));
		Assert.assertEquals(getDriver().findElement(By.className("active")).getText(),itemExpected);
		
	}

}
