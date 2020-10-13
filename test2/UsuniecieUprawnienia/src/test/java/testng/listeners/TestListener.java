package testng.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.Set;

public class TestListener implements ITestListener {


    @Override
    public void onFinish(ITestContext context) {
        Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
        Set<ITestResult> skippedTests = context.getSkippedTests().getAllResults();
        for (ITestResult temp : failedTests) {
            ITestNGMethod method = temp.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                failedTests.remove(temp);
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    failedTests.remove(temp);
                }
            }
        }
        for (ITestResult temp : skippedTests) {
            ITestNGMethod method = temp.getMethod();
            if (context.getSkippedTests().getResults(method).size() > 1) {
                skippedTests.remove(temp);
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    skippedTests.remove(temp);
                }
            }
        }
    }

    public void onTestStart(ITestResult result) {
        System.out.println(result.getName()+" test case started");

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of the testcase passed is :"+result.getName());

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("The name of the testcase failed is :"+result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the testcase Skipped is :"+result.getName());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {

    }
}