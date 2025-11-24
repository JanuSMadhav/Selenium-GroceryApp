package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	//click new button
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement clicknewbutton;
		public AdminPage clickNewButton() {
		//WebElement clicknewbutton = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		clicknewbutton.click();	
		pageutility.clickOnElement(clicknewbutton);
		return this;
		}
	//Add new user
	@FindBy(xpath="//input[@type='text' and @id='username']") WebElement newusername;
	public AdminPage addNewAdmin(String randomusername) {
		WebElement newusername = driver.findElement(By.xpath("//input[@type='text' and @id='username']"));
		//newusername.sendKeys(randomusername);
		pageutility.sendDataToElement(newusername, randomusername);
		return this;
	}
	@FindBy(xpath="//input[@type='password' and @id='password']") WebElement newpassword;
	public AdminPage addPassword(String randompassword) {
		WebElement newpassword = driver.findElement(By.xpath("//input[@type='password' and @id='password']"));
		//newpassword.sendKeys(randompassword);
		pageutility.sendDataToElement(newpassword, randompassword);
		return this;
	}
	//Select user type
	@FindBy(xpath="//select[@class='form-control' and @name='user_type']") WebElement usertype;
	public AdminPage selectUsertype() {
		//WebElement usertype = driver.findElement(By.xpath("//select[@class='form-control' and @name='user_type']"));
		Select select = new Select(usertype);
		//select.selectByVisibleText(Constant.ADMINTYPE);
		pageutility.selectData(usertype);
		return this;
	}
	
	//save new admin
	@FindBy(xpath="//button[@type='submit' and @name='Create']") WebElement savebutton;
	public AdminPage saveUser() {
		//WebElement savebutton = driver.findElement(By.xpath("//button[@type='submit' and @name='Create']"));
		//savebutton.click();
		pageutility.clickOnElement(savebutton);
		return this;
	}
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	public boolean isAlertDisplayed() {
	//	WebElement alert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		return alert.isDisplayed();
		}
	
}

