package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public void getScreenshot(WebDriver driver,String failedTestCase) throws IOException
	{
	TakesScreenshot scrShot = (TakesScreenshot) driver;//class in selenium to take screenshots. Typecasting driver to takescreenshot class
	File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//getScreenshotAs built in method is invoked using the object of take screenshot in a specified format class

	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//creating time stamp to know the time of execution
	File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");//create folder in  directory to save the screenshots
	if (!f1.exists()) {
	f1.mkdirs();//java file handling method to create folders is mkdirs
	}
	String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp //the name of the failed test case is passed to failedTestCase
	+ ".png";
	File finalDestination = new File(destination);//a new file is created (empty file)
	FileHandler.copy(screenShot, finalDestination);//screenshot is copied and saved to finaldestination, copies file from one source to another destination. Screenshot is moved to finaldestination file
	}
}