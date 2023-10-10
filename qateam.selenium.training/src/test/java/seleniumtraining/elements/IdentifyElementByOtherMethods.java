package seleniumtraining.elements;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seleniumtraining.common.BaseTest;
import seleniumtraining.common.SeleniumUtils;

public class IdentifyElementByOtherMethods extends BaseTest{
	
	/*
	 * Identify Password field by name
	 */
	@Test
	public void test01() throws Exception{
        WebElement element = driver.findElement(By.name("password"));
        SeleniumUtils.printElementInfo("Password Text Box", element);
	}

	/*
	 * Identify Login label field by Tag Name
	 */
	@Test
	void test02() throws Exception{
        WebElement element = driver.findElement(By.tagName("h5"));
        SeleniumUtils.printElementInfo("Login label", element);
	}

	/*
	 * Identify Password field by Class Name
	 */
	@Test
	void test03() throws Exception{
        WebElement element = driver.findElement(By.className("oxd-input--active"));
        SeleniumUtils.printElementInfo("Password Text Box", element);
	}

	/*
	 * Identify Login button by Class Name (using one class from multiple classes)
	 */
	@Test
	void test04() throws Exception{
        WebElement element = driver.findElement(By.className("orangehrm-login-button"));
        SeleniumUtils.printElementInfo("Login button", element);
	}

}
