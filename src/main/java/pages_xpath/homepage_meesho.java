package pages_xpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage_meesho {
	
	

	
	
	@FindBy(xpath="//li[@class='nav-item dropdown']//a[normalize-space()='Desktops']")
	public WebElement popular_dropdown;
	
	
	
	
	

	
	public WebDriver driver;
	
	public homepage_meesho(WebDriver driver ) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
