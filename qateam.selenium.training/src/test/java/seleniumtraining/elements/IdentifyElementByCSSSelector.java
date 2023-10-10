package seleniumtraining.elements;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import seleniumtraining.common.BaseTest;
import seleniumtraining.common.SeleniumUtils;

public class IdentifyElementByCSSSelector extends BaseTest{
	
	/*
	 * Identifies Login button with CSS Selector (Tag name) -- ORANGE HRM PAGE
	 */
	@Test
	void test01() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("button"));
        SeleniumUtils.printElementInfo("Login button", element);
	}

	/*
	 * Identifies Login button with CSS Selector (Tag name and a given attribute)
	 */
	@Test
	void test02() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("button[type]"));
        SeleniumUtils.printElementInfo("Login button", element);
	}

	/*
	 * Identifies Login button with CSS Selector (Tag name, a given attribute and attribute value)
	 */
	@Test
	void test03_01() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("button[type='submit']"));
        SeleniumUtils.printElementInfo("Login button", element);
	}

	/*
	 * Identifies Login button with CSS Selector (Name - variant of test03)
	 */
	@Test
	void test03_02() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("input[name='username']"));
        SeleniumUtils.printElementInfo("User Name Text box", element);
	}

	/*
	 * Identifies Username text field with CSS Selector (Class - variant of test03)
	 */
	@Test
	void test03_03() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("input[placeholder='Username']"));
        SeleniumUtils.printElementInfo("User Name Text box", element);
	}
	
	/*
	 * Identifies Username text field with CSS Selector Special Symbols - (# means ID)
	 */
//	@Test
//	void test04_01() throws Exception {
//        WebElement element = driver.findElement(By.cssSelector("#user_login"));
//        SeleniumUtils.printElementInfo("User Name Text box", element);
//	}
	
	/*
	 * Identifies Password text field with CSS Selector Special Symbols - (. means Class)
	 */
	@Test
	void test04_02() throws Exception {
        WebElement element = driver.findElement(By.cssSelector(".oxd-input--active"));
        SeleniumUtils.printElementInfo("Password Text box", element);
	}


	/*
	 * Identifies Username text field with CSS Selector Special Symbols - (* to mean any tag)
	 */
	@Test
	void test04_03() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("*[placeholder='Username']"));
        SeleniumUtils.printElementInfo("User Name Text box", element);
	}

	/*
	 * Identifies Login button with CSS Selector - Relationship (Parent-Child). Denoted with >
	 */
	@Test
	void test05_01() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("div>button"));
        SeleniumUtils.printElementInfo("User Name Text box", element);
	}
	
	/*
	 * Identifies Password label with CSS Selector - Relationship (Sibling) Denoted with +
	 */
	@Test
	void test05_02() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("p+p"));
        SeleniumUtils.printElementInfo("User Name Text box", element);
	}

	/*
	 * Identifies Username text field with CSS Selector - Partial Match - Contains - *=
	 */
	@Test
	void test06_01() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("input[placeholder*='name']"));
        SeleniumUtils.printElementInfo("User Name Text box", element);
	}

	/*
	 * Identifies Username text field with CSS Selector - Partial Match - Start with - ^=
	 */
	@Test
	void test06_02() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("input[placeholder^='User']"));
        SeleniumUtils.printElementInfo("User Name Text box", element);
	}
	
	/*
	 * Identifies Username text field with CSS Selector - Partial Match - Ends with - $=
	 */
	@Test
	void test06_03() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("input[placeholder$='name']"));
        SeleniumUtils.printElementInfo("User Name Text box", element);
	}

	/*
	 * Identifies Login button with CSS Selector - Logical OR (comma ,)
	 */
	@Test
	void test07_01() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("button, *[type='submit']"));
        SeleniumUtils.printElementInfo("Login button", element);
	}
	
	/*
	 * Identifies Login button with CSS Selector - You can give a class
	 * with . operator which acts as an and condition on the previous part of CSS Selector
	 */
	@Test
	void test07_02() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("button.oxd-button"));
        SeleniumUtils.printElementInfo("Login button", element);
	}

	/*
	 * Identifies Password text field with CSS Selector - You can give an identifier
	 * with # operator which acts as an and condition on the previous part of CSS Selector
	 */
//	@Test
//	void test07_03() throws Exception {
//        WebElement element = driver.findElement(By.cssSelector("input#user_pass"));
//        SeleniumUtils.printElementInfo("Password text box", element);
//	}

	/*
	 * Identifies Password text field with CSS Selector - Using not() function
	 */
	@Test
	void test07_04() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("input:not([name='username'])"));
        SeleniumUtils.printElementInfo("Password text box", element);
	}
	
	/*
	 * Identifies Password text field with CSS Selector - Multiple Attr (only attr names)
	 */
	@Test
	void test08_01() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("input[type][placeholder]"));
        SeleniumUtils.printElementInfo("Password text box", element);
	}
	
	/*
	 * Identifies Password text field with CSS Selector - Multiple Attr with values
	 */
	@Test
	void test08_02() throws Exception {
        WebElement element = driver.findElement(By.cssSelector("input[type='password'][placeholder='Password']"));
        SeleniumUtils.printElementInfo("Password text box", element);
	}

}
