package academy;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import academy.Base;

public class Listeners implements ITestListener {

	Base b = new Base();

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
