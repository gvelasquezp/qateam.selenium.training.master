package seleniumtraining.selenium;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seleniumtraining.common.BaseTestNew;
import java.util.List;

public class SeleniumNestedElements extends BaseTestNew{
	
	@Test
	public void testNestedElements() throws Exception {
		
		List<WebElement> menuItems = getDriver().findElements(By.className("oxd-main-menu-item-wrapper"));
		
		System.out.println("Menu items count:" + menuItems.size());
		
		String itemExpected = "Admin";
		
		for(WebElement element: menuItems) {
			System.out.println("Menu item label:" + element.getText());
			if(element.getText().equals(itemExpected)) element.click();
			break;
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h5")));
		Assert.assertEquals(getDriver().findElement(By.className("active")).getText(),itemExpected);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-table-body")));
		WebElement systemUsers = getDriver().findElement(By.className("oxd-table-body"));
		WebElement specificUser = systemUsers.findElement(By.xpath("//div[contains(text(),'Alice.Duval')]"));
		
		System.out.println("Specific User Name :" + specificUser.getText());
		
	}

}
