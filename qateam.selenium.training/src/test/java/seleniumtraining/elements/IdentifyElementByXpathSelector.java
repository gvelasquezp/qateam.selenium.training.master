package seleniumtraining.elements;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seleniumtraining.common.BaseTest;
import seleniumtraining.common.SeleniumUtils;

public class IdentifyElementByXpathSelector extends BaseTest{
	
	/*
	 * Identifies Username text field with Absolute XPath (Tag name)
	 * Don't do this in pofessional work. Absolute XPaths are evil :-)
	 */
	@Test
	void test00() throws Exception {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        SeleniumUtils.printElementInfo("Username text box", element);
	}

	/*
	 * Now onwards we stick to relative XPaths as abolsute xpaths brittle
	 * Identifies Login button with XPath (Tag name)
	 */
	@Test
	void test01() throws Exception {
        WebElement element = driver.findElement(By.xpath("//button"));
        SeleniumUtils.printElementInfo("Login button", element);
	}
	
	
	/*
	 * Identifies Login button with XPath (Tag name and attr name)
	 */
	@Test
	void test02() throws Exception {
        WebElement element = driver.findElement(By.xpath("//button[@type]"));
        SeleniumUtils.printElementInfo("Login button", element);
	}
	
	/*
	 * Identifies Password text field with XPath (Tag name and attr value)
	 */
	@Test
	void test03_01() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@type='password']"));
        SeleniumUtils.printElementInfo("Password text box", element);
	}
	
	/*
	 * Identifies Username text field with XPath - Variant of test03_01: ID
	 */
//	@Test
//	void test03_02() throws Exception {
//        WebElement element = driver.findElement(By.xpath("//input[@id='user_login']"));
//        SeleniumUtils.printElementInfo("Username text field", element);
//	}

	/*
	 * Identifies Username text field with XPath - Variant of test03_01: Class Name
	 */
	@Test
	void test03_03() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']"));
        SeleniumUtils.printElementInfo("Username text field", element);
	}

	/*
	 * Identifies Username text field with XPath - Variant of test03_01: Placeholder
	 */
	@Test
	void test03_04() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        SeleniumUtils.printElementInfo("Username text field", element);
	}	

	/*
	 * Identifies Username text field with XPath - Variant of test03_01: Any Tag with attr value
	 */
	@Test
	void test03_05() throws Exception {
        WebElement element = driver.findElement(By.xpath("//*[@placeholder='Username']"));
        SeleniumUtils.printElementInfo("Username text field", element);
	}	

	/*
	 * Identifies Forgot your password link with XPath - Text
	 */
	@Test
	void test04() throws Exception {
        WebElement element = driver.findElement(By.xpath("//*[text()='Forgot your password? ']"));
        SeleniumUtils.printElementInfo("Password Lost link", element);
	}
	
	/*
	 * Identifies Identifies Login button with XPath - Relationships - Child
	 */
	@Test
	void test05_01() throws Exception {
        WebElement element = driver.findElement(By.xpath("//div/button"));
        SeleniumUtils.printElementInfo("Login button", element);
	}

	/*
	 * Identifies Login title with XPath - Relationships - Following Sibling
	 */
	@Test
	void test05_02() throws Exception {
        WebElement element = driver.findElement(By.xpath("//div/following-sibling::h5"));
        SeleniumUtils.printElementInfo("Login title", element);
	}
	
	/*
	 * Identifies Username text field with XPath - Partial Match - Attr value Contains
	 */
	@Test
	void test06_01() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[contains(@name, 'serna')]"));
        SeleniumUtils.printElementInfo("Username text box", element);
	}
	
	/*
	 * Identifies Username text field with XPath - Partial Match - Attr value Starts With
	 */
	@Test
	void test06_02() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[starts-with(@name, 'user')]"));
        SeleniumUtils.printElementInfo("Username text box", element);
	}
	
	/*
	 * Identifies Username text field with XPath - Partial Match - Attr value Ends With
	 */
//	@Test
//	void test06_03() throws Exception {
//		// ends-with is not supported in current browsers. As it requires Xpath 2.0 where
//		// all browsers use Xpath 1.0
//		WebElement userNameTxtField = driver.findElement(By.xpath("//input[ends-with(@id, '_login')]"));
//        System.out.println(userNameTxtField);
//	}
	
	/*
	 * Identifies Username label with XPath - Partial Match - Text contains
	 */
	@Test
	void test06_04() throws Exception {
        WebElement element = driver.findElement(By.xpath("//label[contains(text(), 'name')]"));
        SeleniumUtils.printElementInfo("Username label", element);
	}

	/*
	 * Identifies Username label with XPath - Partial Match - Text starts with
	 */
	@Test
	void test06_05() throws Exception {
        WebElement element = driver.findElement(By.xpath("//label[starts-with(text(), 'User')]"));
        SeleniumUtils.printElementInfo("Username label", element);
	}
	
	/*
	 * Identifies Username text box with XPath - Logical OR : Using or keyword
	 */
	@Test
	void test07_01() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@name='username' or @id ='username']"));
        SeleniumUtils.printElementInfo("Username text box", element);
	}

	/*
	 * Identifies Password text field with XPath - Logical AND : Using and keyword
	 */
	@Test
	void test07_02() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@name='password' and @type ='password']"));
        SeleniumUtils.printElementInfo("Password text box", element);
	}

	/*
	 * Identifies Password text field with XPath - Logical Not : Using not() function
	 */
	@Test
	void test07_03() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and not(@name ='username')]"));
        SeleniumUtils.printElementInfo("Password text box", element);
	}
	
	/*
	 * Identifies Login Form with XPath - Hierarchy (Axis) - Parent
	 */
	@Test
	void test08_01() throws Exception {
        WebElement element = driver.findElement(By.xpath("//button/../.."));
        SeleniumUtils.printElementInfo("Login Form", element);
	}
	
	/*
	 * Identifies Identifies Login button with XPath - Hierarchy (Axis) - Descendant (Using // instead of / between form and input)
	 */
	@Test
	void test08_02() throws Exception {
        WebElement element = driver.findElement(By.xpath("//form//button"));
        SeleniumUtils.printElementInfo("Login button", element);
	}
	
	/*
	 * Identifies Login Form with XPath - Hierarchy (Axis) - Ancestor (Using /ancestor)
	 */
	@Test
	void test08_03() throws Exception {
        WebElement element = driver.findElement(By.xpath("//button/ancestor::form"));
        SeleniumUtils.printElementInfo("Form", element);
	}

	/*
	 * Identifies Password label field with XPath - Hierarchy (Axis) - Preceding Sibling (starting from submit paragraph)
	 */
	@Test
	void test08_04() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@name='password']/../preceding-sibling::div"));
        SeleniumUtils.printElementInfo("Password label field", element);
	}

	/*
	 * Identifies Username text field with XPath - Index (Index uses Human counting)
	 * This variant looks at children of the same parent.
	 * That is the reason //input[2] does not point to Password field
	 */
	@Test
	void test09_01() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[1]"));
        SeleniumUtils.printElementInfo("Username text box", element);
	}

	/*
	 * Identifies Username text field with XPath - Index (Index uses Human counting)
	 * This variant looks at elements across the DOM.
	 * Here (//input)[3] would point to password field
	*/
	@Test
	void test09_02() throws Exception {
        WebElement element = driver.findElement(By.xpath("(//input)[2]"));
        SeleniumUtils.printElementInfo("Username text box", element);
	}
	
	/*
	 * Identifies Password text field with XPath - Multi attr names
	 */
	@Test
	void test10_01() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@type and @placeholder]"));
        SeleniumUtils.printElementInfo("Password text box", element);
	}
	
	/*
	 * Identifies Password text field with XPath - Multi attr names and values
	 */
	@Test
	void test10_02() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@type='password' and @placeholder='Password']"));
        SeleniumUtils.printElementInfo("Password text box", element);
	}

}
