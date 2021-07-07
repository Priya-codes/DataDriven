package com.selenium.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.testbase.TestBase;
import com.selenium.utilities.TestUtility;

public class CustomListeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
    test=repo.startTest(result.getTestName().toUpperCase())	;
	}

	public void onTestSuccess(ITestResult result) {
	  test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		repo.endTest(test);
		repo.flush();// without this report wont be generating 
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtility.capatureScreenShots();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  test.log(LogStatus.FAIL, result.getName().toUpperCase()+"FAILED with exception"+ result.getThrowable());
		  test.log(LogStatus.FAIL, test.addScreenCapture(TestUtility.screenshotName));

		Reporter.log("<a target=\"_blank\" href="+TestUtility.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtility.screenshotName+"><img src="+TestUtility.screenshotName+ "  height=200 width=200></img></a>");
		repo.endTest(test);
		  repo.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	;
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		
		// TODO Auto-generated method stub
	}

	
}
