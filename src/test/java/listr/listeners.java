package listr;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import util.ExtentReporter;

public class listeners implements ITestListener {
	ExtentReports extentreports = ExtentReporter.getExtentReport();
	@Override
	public void onTestStart(ITestResult result) {
		
		ExtentTest extentTest = extentreports.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS,"Test got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest extentTest;
		extentTest.log(Status.FAIL,"Test got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreports.flush();
	}

}
