package seleniumtraining.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import seleniumtraining.common.BaseTestNew;
import seleniumtraining.common.Configuration;
import java.io.File;

public class SeleniumTakeAScreenshot extends BaseTestNew{
	
	@Test
	public void testTakeAScreenshot() throws Exception {
		
		//Create screenshots folder
		TakesScreenshot camera = (TakesScreenshot) getDriver();
		File sFile = camera.getScreenshotAs(OutputType.FILE);
		String path = String.format("%s%s-%s.png", Configuration.SCREENSHOTS_DIR, "dashboard", System.currentTimeMillis());
		System.out.println(path);
		sFile.renameTo(new File(path));
		
	}

}
