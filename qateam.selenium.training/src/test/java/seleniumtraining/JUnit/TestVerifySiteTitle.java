package seleniumtraining.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import seleniumtraining.common.Configuration;

class TestVerifySiteTitle {

	@Test
	void verifySiteTitle() throws Exception{
		WebDriver driver = Configuration.createChromeDriver();
        driver.get(Configuration.BLOG_URL);
        String expectedTitle = "WrongTitle";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
        driver.quit();	
	}
}
