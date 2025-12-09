package utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.DriverFactory;

public class ShadowUtils {
	
	 public static WebElement getShadowElement(String selector) {
	        WebDriver driver = DriverFactory.getDriver();
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        return (WebElement) js.executeScript(
	                "return document.querySelector('" + selector + "').shadowRoot.querySelector('" + selector + "');"
	        );
	    }

}
