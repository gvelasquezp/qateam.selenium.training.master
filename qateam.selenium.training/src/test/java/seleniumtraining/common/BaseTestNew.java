package seleniumtraining.common;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTestNew {
	
	protected WebDriver driver = null;
	protected Wait<WebDriver> wait = null;
	
	@BeforeEach
	public void login() throws Exception {
		driver = Configuration.createChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Login
		driver.get(Configuration.BLOG_URL);
        WebElement userTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        userTextBox.sendKeys(Configuration.USER_NAME);
        WebElement pwdTextBox = driver.findElement(By.name("password"));
        pwdTextBox.sendKeys(Configuration.PASSWORD);
        pwdTextBox.submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-main-menu")));
	}

	@AfterEach
	public void logout() throws Exception {
		//Logout
		driver.findElement(By.cssSelector(".oxd-userdropdown-tab")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		driver.quit();
	}

	protected WebDriver getDriver(){
		return this.driver;
	}

	protected Wait<WebDriver> getWaiter(){
		return this.wait;
	}
	
}
