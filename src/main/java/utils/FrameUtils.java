package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import base.DriverFactory;

public class FrameUtils {
	
	
	private static String detectedFrame = null;

    public static void switchToOtpFrame() {

        WebDriver driver = DriverFactory.getDriver();
        driver.switchTo().defaultContent();

        // If we already detected the frame earlier, reuse it
        if (detectedFrame != null && !detectedFrame.isBlank()) {
            try {
                driver.switchTo().frame(detectedFrame);
                System.out.println("✔ Reused stored iframe: " + detectedFrame);
                return;
            } catch (Exception e) {
                System.out.println("⚠️ Stored iframe not valid anymore, re-scanning...");
                detectedFrame = null; // reset and find again
            }
        }

        // Scan all iframes
        for (WebElement frame : driver.findElements(By.tagName("iframe"))) {
            driver.switchTo().frame(frame);

            if (driver.findElements(By.xpath("//label[contains(text(),'Mobile Number')]")).size() > 0 ||
                driver.findElements(By.xpath("//input[@placeholder='Enter your 10 digit mobile number']")).size() > 0) {

                detectedFrame = frame.getAttribute("id");
                System.out.println("✔ OTP Frame detected and stored: " + detectedFrame);
                return;
            }

            driver.switchTo().defaultContent();
        }

        throw new AssertionError("❌ Unable to locate OTP iframe");
    }

}
