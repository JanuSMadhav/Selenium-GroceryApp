package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility { // the template in which the report should be generated is implemented here
	public static final ExtentReports extentReports = new ExtentReports();//static instance of extentreports that can be shared accross the application
//ExtentReports class is exclusively used for generating reports
	public synchronized static ExtentReports createExtentReports() { //synchronized static: to have a preparation time between executing statements. extents report may not support this and follows asynchronously
		//Creates an instance of the reporter that will generate the HTML report in the path "./extent-reports/extent-report.html".
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//the format in which report should be generated: html format. 
		//ExtentSparkReporter is a class used to generate modern, interactive, and visually rich HTML reports for test automation frameworks, especially with Selenium + TestNG / JUnit.
		reporter.config().setReportName("7R Mart SuperMarket");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", " Janu"); //provides context of the report
		return extentReports;
	}
}
