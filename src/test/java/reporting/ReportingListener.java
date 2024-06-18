package reporting;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import config.Hooks;

public class ReportingListener extends Hooks implements ITestListener {
	
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	public File srcFile;
	public File destFile;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test "+result.getName()+" Passed!");
	}
	
    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test " + result.getName() + " Failed!");
        if (driver != null) {
            try {
                // Take screenshot
            	destFile = new File(configProps.get("screenshot_directory")+"/"+"screenshot_"+System.currentTimeMillis()+".png");
                srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile, destFile);
                test.addScreenCaptureFromPath(destFile.getAbsolutePath(), "Captured Screenshot");
            } catch (IOException e) {
                System.out.println("Error saving screenshot " + e.getMessage());
            }
        } else {
            System.out.println("WebDriver instance is null. Cannot take screenshot.");
        }
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
	
}
