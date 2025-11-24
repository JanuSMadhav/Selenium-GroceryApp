 package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	//wait utility object
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	public HomePage(WebDriver driver) {
	this.driver = driver;
	//page factory initialization
	PageFactory.initElements(driver, this); 	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin;
	public HomePage adminButton() {
	/*  WebElement admin = driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
		admin.click();*/
		waitutility.waitUntilClickable(driver, admin);
		pageutility.clickOnElement(admin);
		return this;
	}
	@FindBy(xpath="i[@class='ace-icon fa fa-power-off']") WebElement logout;
public LoginPage logout() {
	//WebElement logout = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
	waitutility.waitUntilClickable(driver, logout);
	//logout.click();	
	pageutility.clickOnElement(logout);
	return new LoginPage(driver);
}
//Click Admin User. As the admin comes in Home page we change the code from Admin page to Home page
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminuser;
	public AdminPage clickAdminUser() {
		//WebElement adminuser = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
			//adminuser.click();
		pageutility.clickOnElement(adminuser);
		return new AdminPage(driver);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement managenews;
	public NewsPage clickManageNews() {
//	WebElement managenews = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']"));
	//managenews.click();
	pageutility.clickOnElement(managenews);
	return new NewsPage(driver);
	}
	
}
