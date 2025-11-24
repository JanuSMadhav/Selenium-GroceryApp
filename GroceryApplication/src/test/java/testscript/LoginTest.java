package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Constant;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase{
	public HomePage homepage;//initialize object home
	//Actions are chained. If valid credentials are used, we move to the homepage
	@Test (priority = 1, description = "verifying login to the webpage with valid username and valid password", retryAnalyzer= retry.Retry.class)//using retry class
	//if retry mechanism is used then the test case would be flaky
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, Constant.LOGINSHEET);//reading data from excel file: data driven approach
		String passwordvalue = ExcelUtility.getStringData(1, 1, Constant.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		//loginpage.enterUserName(usernamevalue);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);//chaining of methods
		//loginpage.enterPassword(passwordvalue);
		homepage=loginpage.signin();//chaining of methods and classes for the first test case
		/*WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernamevalue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordvalue);
		WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();	*/
		//Hard Assertion
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin";
		Assert.assertEquals(actual,expected, Messages.VALID_CREDENTIAL_ASSERT); //softassert. (if soft assertion is used)
		//if assertion fails, an error 'Assertion failed' will be returned
	}
	
	@Test	(priority = 2, description = "verifying login to the webpage with invalid username and valid password")
	
	public void verifyLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, Constant.LOGINSHEET);//reading data from excel file: data driven approach
		String passwordvalue = ExcelUtility.getStringData(2, 1, Constant.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue).signin();
		//signin is not assigned to home because we login using invalid credentials and stay in the login page itself
		/*loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.signin();*/
		/*WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernamevalue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordvalue);
		WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();	*/
		//Assertion
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		Assert.assertEquals(actual, expected, Messages.INVALID_USERNAME_ASSERT);
	}
	
	@Test (priority = 3, description = "verifying login to the webpage with valid username and invalid password")
		
	public void verifyLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(3, 0, Constant.LOGINSHEET);
		String passwordvalue = ExcelUtility.getStringData(3, 1, Constant.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue).signin();
		/*loginpage.enterPassword(passwordvalue);
		loginpage.signin();*/
		/*WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernamevalue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordvalue);
		WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();	*/
		//Assertion
				String actual = driver.getCurrentUrl();
				String expected = "https://groceryapp.uniqassosiates.com/admin/login";
				Assert.assertEquals(actual, expected,Messages.INVALID_PASSWORD_ASSERT);
}

	@Test (priority = 4, description = "verifying login to the webpage with invalid username and invalid password", dataProvider = "loginProvider")//data provider is added in the description to access the data. Passing string values as data provider contains string data
	public void verifyLoginWithInvalidUsernameAndInvalidPassword(String username, String password) throws IOException {
		/*String usernamevalue = ExcelUtility.getStringData(4, 0, Constant.LOGINSHEET);
		String passwordvalue = ExcelUtility.getStringData(4, 1, Constant.LOGINSHEET);*/
		//String passwordvalue = ExcelUtility.getStringData(4, 1, "LoginSheet");//old format before adding constants
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password).signin();
		/*loginpage.enterPassword(password);
		loginpage.signin();*/
		/*WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernamevalue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordvalue);
		WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();	*/
		//Assertion 
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		Assert.assertEquals(actual, expected, Messages.INVALID_CREDENTIAL_ASSERT);
	}

//Data Provider
@DataProvider(name="loginProvider")//annotation used to set the name 'loginProvider'. A parameter should be provided and a value should be assigned to the 
public Object[][] getDataFromDataProvider() throws IOException//syntax of data provider
{
	return new Object[][] { new Object[] {"user","password"},//format to return object. data in the curly braces are the input data for username and password fields
		new Object[] {"username","pass"},
		new Object[] {"user","password"}
	};
}
}

