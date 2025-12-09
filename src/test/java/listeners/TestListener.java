package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtils.takeScreenshot(result.getName());
        System.out.println("Screenshot saved at: " + path);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Suite finished: " + context.getName());
    }
}
