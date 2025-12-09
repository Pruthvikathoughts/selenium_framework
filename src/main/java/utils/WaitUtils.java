package utils;

import base.DriverFactory;
import config.FrameworkConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait getWait() {
        return new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(FrameworkConfig.getExplicitWait())
        );
    }


    /** Wait for element using By locator */
    public static WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }


    /** ⭐ NEW: Wait for WebElement (PageFactory style) */
    public static WebElement waitForElement(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForAlert() {
        getWait().until(ExpectedConditions.alertIsPresent());
    }
}
