package retry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer { //IRetryAnalyzer interface to implement retry mechanism
	
//typecasting to logger, the class that has the log and saving it as an object to the logger interface
		private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class"); //Logger is an interface to capture and save logs. creating an object LOG to log the error
		private static final int maxTry = 2; //number of retries =2 (if 1st retry succeeds then the code will not be executed next)
		private int count = 0;

		@Override
		public boolean retry(final ITestResult iTestResult) { //interface method. Rephrasing the method in such a way that if the test case succeeds then the code need not be retried
			if (!iTestResult.isSuccess()) {
				if (this.count < maxTry) {//capture the error to LOG.info (reason for failure)
					LOG.info("Retrying test " + iTestResult.getName() + " with status "
							+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
					this.count++;
					return true;
				}
			}
			return false;
		}

		public String getResultStatusName(final int status) {
			String resultName = null;
			if (status == 1) {
				resultName = "SUCCESS";
			}
			if (status == 2) {
				resultName = "FAILURE";
			}
			if (status == 3) {
				resultName = "SKIP";
			}
			return resultName;
		}
	}


