package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementationClass implements IRetryAnalyzer {
	int count = 1;
	int limit = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		
		while(count<=limit) {
			count++;
			return true;
		}
		return false;
	}

}
