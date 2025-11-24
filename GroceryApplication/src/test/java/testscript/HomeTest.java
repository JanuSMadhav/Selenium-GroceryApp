package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import pages.AdminPage;
import pages.HomePage;
import constants.Constant;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	public HomePage homepage;
	public AdminPage adminpage;
	 public LoginPage loginpage;
	@Test (priority = 1, description = "Verify logout after logging in")
	
	public void verifyLogoutfunctionality() throws IOException  {
		String usernamevalue = ExcelUtility.getStringData(1, 0, Constant.LOGINSHEET);//reading data from excel file: data driven approach
		String passwordvalue = ExcelUtility.getStringData(1, 1, Constant.LOGINSHEET);
		//Login to Grocery Application
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.signin();
		/*loginpage.enterPassword(passwordvalue);
		loginpage.signin();*/
		
		/*WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernamevalue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordvalue);
		WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();	*/
						
		//Click Admin dropdown for logging out
		/*WebElement admin = driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
		admin.click();
		//Click Logout button
		WebElement logout = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
		logout.click();	*/
		homepage.adminButton();
		loginpage=homepage.logout();
		
		//Assertion
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		Assert.assertEquals(actual, expected, Messages.LOGIN_AFTER_LOGOUT_ASSERT);
	}	
 
}
