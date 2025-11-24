package reportGeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReportUtility;


public class Listener implements ITestListener { //implements a built-in interface and overrides some methods and captures all the test case related methods
	ExtentTest test;
	ExtentReports extent = ExtentReportUtility.createExtentReports();//assigns to object extent
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) { // things to passed to the report when test starts

		ITestListener.super.onTestStart(result);
		//test = extent.createTest(result.getMethod().getMethodName());
		// Get test method name
	    String methodName = result.getMethod().getMethodName();

	    // Get @Test description (can be null if not set)
	    String description = result.getMethod().getDescription();

	    // Fallback in case description is missing
	    if (description == null || description.isEmpty()) {
	        description = "No description provided.";
	    }

	    // Create test with name and description
	    test = extent.createTest(methodName, description);
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) { //how to give data to report when test cases succeed

		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");

	}
	/*
	 * @Override public void onTestFailure(ITestResult result) { // Mark the test as
	 * failed in Extent extentTest.get().log(Status.FAIL, "Test Failed");
	 * 
	 * // Extract the Throwable (the exception or assertion error) Throwable
	 * throwable = result.getThrowable();
	 * 
	 * // Extract just the assertion message (or exception message) String
	 * errorMessage = (throwable != null) ? throwable.getMessage() :
	 * "No error message available";
	 * 
	 * // Log the message separately (for visibility)
	 * extentTest.get().log(Status.FAIL, "Assertion Error: " + errorMessage);
	 * 
	 * // Log the full stack trace (optional but useful) if (throwable != null) {
	 * extentTest.get().fail(throwable); }
	 * 
	 * // Optional: Add screenshot code here if needed }
	 */

	
	  public void onTestFailure(ITestResult result) { //passes data to report when the test case fails
	  
	  ITestListener.super.onTestFailure(result); extentTest.get().log(Status.FAIL,
	  "Test Failed"); extentTest.get().fail(result.getThrowable()); WebDriver
	  driver = null; String testMethodName = result.getMethod().getMethodName();
	  try { driver = (WebDriver)
	  result.getTestClass().getRealClass().getDeclaredField("driver")
	  .get(result.getInstance()); } catch (IllegalArgumentException e) {
	  
	  e.printStackTrace(); } catch (IllegalAccessException e) {
	  
	  e.printStackTrace(); } catch (NoSuchFieldException e) {
	  
	  e.printStackTrace(); } catch (SecurityException e) {
	  
	  e.printStackTrace(); }
	  
	  try { driver = (WebDriver)
	  result.getTestClass().getRealClass().getDeclaredField("driver")
	  .get(result.getInstance()); } catch (Exception e) { }
	  }
	 

	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {//pushes the data to report

		ITestListener.super.onFinish(context);
		extent.flush();//entire data is pushed to report
	}

}
