package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class NewsPage {

	//wait utility object
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	public WebDriver driver;
	//constructor
	public NewsPage(WebDriver driver) {
		this.driver = driver;
		//page factory initialization
		PageFactory.initElements(driver, this);
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}	
		//Login to Grocery Application
//	@FindBy(xpath="//input[@name='username']") WebElement username;
//		public NewsPage enterUsername (String usernamevalue) {
//	/*	WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
//		t5hswh3gwghusername.sendKeys(usernamevalue);*/
//			pageutility.sendDataToElement(username, usernamevalue);
//			return this;
//		}
//	@FindBy(xpath="//input[@name='password']") WebElement password;
//		public NewsPage enterPassword(String passwordvalue) {
//		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//		password.sendKeys(passwordvalue);
//		pageutility.sendDataToElement(password, passwordvalue);
//		return this;
//		}
//	@FindBy(xpath="//button[@type='submit']") WebElement signin;
//		public NewsPage signin() {
//	//	WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
//		waitutility.waitUntilClickable(driver, signin);
//	//	signin.click();	
//		pageutility.clickOnElement(signin);
//		return this;
//		}
		
		//Click Manage News
	
		//Add news
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") WebElement addnews;
		public NewsPage clickaddNews() {
	// WebElement addnews = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']"));
		//addnews.click();
		pageutility.clickOnElement(addnews);
		return this;
		}
	@FindBy(xpath="//textarea[@id='news']") WebElement addnewstext;
		public NewsPage addNews() {
	//	WebElement addnewstext = driver.findElement(By.xpath("//textarea[@id='news']"));
		//addnewstext.sendKeys("Explore news");
		pageutility.sendDataToElement(addnewstext, "Explore news");
		return this;
		}
	@FindBy(xpath="//button[@type='submit']") WebElement savenews;
		public NewsPage saveNews() {
	//	WebElement savenews = driver.findElement(By.xpath("//button[@type='submit']"));
		savenews.click();
		pageutility.clickOnElement(savenews);
		return this;
		}
		
		@FindBy(xpath="//input[@class='form-control']") WebElement typenews;
		public NewsPage typeNews() {
		//	WebElement typenews = driver.findElement(By.xpath("//input[@class='form-control']"));
			//typenews.sendKeys("today");	
			pageutility.sendDataToElement(typenews, "today");
			return this;
		}
		
		public boolean isSuccessAlertDisplayed() {
		    return driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed();
		}
		
		
    @FindBy(xpath="//button[@class='btn btn-danger btn-fix']") WebElement searchnews;		
		public NewsPage searchNews() {
	    //WebElement searchnews = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-fix']"));
			//searchnews.click();	
			pageutility.clickOnElement(searchnews);
			return this;
		}
		@FindBy(xpath = "//a[text()='Home']") WebElement homebutton;
		public HomePage returntoHome()
		{
			pageutility.clickOnElement(homebutton);
			return new HomePage(driver);
		}
		@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") WebElement resetbutton;
		public NewsPage resetButton()
		{
			pageutility.clickOnElement(resetbutton);
			return this;
		}
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alert;
		public boolean isAlertDisplayed() {
			return pageutility.alertDisplay(alert);
		}
	}


