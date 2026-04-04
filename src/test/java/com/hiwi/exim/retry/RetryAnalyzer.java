package com.hiwi.exim.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int initialCount = 0;
	int retryCount = 3;
	@Override
	public boolean retry(ITestResult result) {
		
		if(initialCount < retryCount) {
			initialCount++;
            System.out.println("Retrying test " + result.getName() + " again, attempt " + initialCount);
            return true;
		}	
		return false;
	}
}
