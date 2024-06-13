package reporting;

import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import config.Hooks;

public class ReportingListener extends Hooks implements ITestListener, ITest{
	
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getTestName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test "+result.getName()+" Passed!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test "+result.getName()+" Failed!");
		// TAKE SCREENSHOT CODE HERE
		//Convert web driver object to TakeScreenshot
//		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//		//Call getScreenshotAs method to create image file
//		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//		//Move image file to new destination
//		File DestFile=new File(fileWithPath);
//		//Copy file at destination
//		FileUtils.copyFile(SrcFile, DestFile);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		 extent = new ExtentReports();
		 spark = new ExtentSparkReporter(configProps.get("reporting_directory"));
		 extent.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public String getTestName() {
		return "";
	}	
}
