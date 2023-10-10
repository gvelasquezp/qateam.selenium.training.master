package seleniumtraining.elements;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seleniumtraining.common.BaseTest;
import seleniumtraining.common.SeleniumUtils;

public class IdentifyElementByIdentifyingLinks extends BaseTest{
	
	/*
	 * Identify Home link by full text
	 */
	@Test
	public void test01() throws Exception{
        WebElement element = driver.findElement(By.linkText("Home"));
        SeleniumUtils.printElementInfo("Home button", element);
	}

	/*
	 * Identify Video Tutorials link by partial text
	 */
	@Test
	void test02() throws Exception{
        WebElement element = driver.findElement(By.partialLinkText("Tutorials"));
        SeleniumUtils.printElementInfo("Video Tutorials button", element);
	}

}
