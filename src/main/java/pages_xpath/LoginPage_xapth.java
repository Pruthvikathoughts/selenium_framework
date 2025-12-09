package pages_xpath;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_xapth {
	
	public WebDriver driver;
	
	 private By usernameInput = By.xpath("//input[@placeholder='Username']");
	    private By passwordInput = By.xpath("//input[@placeholder='Password']");
	    private By loginButton = By.cssSelector(".orangehrm-login-button");
	    private By loginHeader = By.cssSelector("h5.oxd-text");
	    private By dashboardHeader = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
	    private By invlaidLoginElement = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

	    
	    
	  public void enter_user(String username, String password) {
		  
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		
		 
	  }
	
	  
	  public void login() {
		  
		  driver.findElement(loginButton).click();
		  
	  }
	

	  public void verfy_dashbord() {
		Assert.assertTrue(driver.findElement(dashboardHeader).isDisplayed()); 
		
	  }
	  
	  public void error_message() {
		Assert.assertEquals(driver.findElement(invlaidLoginElement).getText(), "Invalid credentials");  
		  
	  }
	  
	
	
	public LoginPage_xapth(WebDriver driver ) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

}
