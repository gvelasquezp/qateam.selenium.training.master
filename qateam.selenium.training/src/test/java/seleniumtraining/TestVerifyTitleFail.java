package seleniumtraining;

import org.openqa.selenium.WebDriver;
import seleniumtraining.common.Configuration;

public class TestVerifyTitleFail {

	public static void main(String[] args) throws Exception {
		WebDriver driver = Configuration.createChromeDriver();
		driver.manage().window().maximize();
        driver.get(Configuration.BLOG_URL);
        Thread.sleep(3000);
        String expectedTitle = "Fail";
        String actualTitle = driver.getTitle();
        if (!expectedTitle.equals(actualTitle)){
        	throw new Exception(
        			String.format("Failure: Title does not match. Expected: <%s> Actual: <%s>",
        			expectedTitle,
        			actualTitle));
        }
        driver.quit();
	}

}
