package testngTests_stepdefination;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;
import config.FrameworkConfig;
import io.cucumber.java.en.And;
import pages_xpath.LoginPage_xapth;
import pages_xpath.homepage_meesho;

public class meesho_homepage {
	
	
	 WebDriver driver;
     WebDriverWait wait;
     homepage_meesho homepage;

	
	public meesho_homepage() {
        this.driver = DriverFactory.getDriver();
        this.homepage = new homepage_meesho(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
	
	
	
	@And("open the Meesho url")
	public void open_the_meesho_url() {
		
	}
	
	
	@And("hover on the popular dropdown")
	public void hover_on_the_popular_dropdown() {
	wait.until(ExpectedConditions.visibilityOf(homepage.popular_dropdown));
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homepage.popular_dropdown);

    Actions action = new Actions(driver);
    action.moveToElement(homepage.popular_dropdown).perform();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
