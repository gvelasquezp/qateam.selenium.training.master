package seleniumtraining.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import seleniumtraining.common.Configuration;

class TestVerifySiteTitleFixtures {

	WebDriver driver = null;

	@BeforeEach
	void launchBrowser() {
        driver = Configuration.createChromeDriver();		
	}

	@Test
	void testSiteTitle() throws Exception{
        driver.get(Configuration.BLOG_URL);
        String expectedTitle = "WrongTitle";//OrangeHRM
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Verifying Site Title");
	}
	
	@AfterEach
	void closeBrowser() {
        driver.quit();		
	}
}
