package seleniumtraining.elements;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumtraining.common.BaseTest;
import seleniumtraining.common.SeleniumUtils;

public class PrintElementInfo extends BaseTest{
	
	/*
	 * Identify Username field by Name
	 */
	@Test
	public void test01() throws Exception{
        WebElement userNameTxtField = driver.findElement(By.className("orangehrm-login-title"));
        SeleniumUtils.printElementInfo("Username Text Box", userNameTxtField);
	}

}
