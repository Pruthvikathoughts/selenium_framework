package testngTests_stepdefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;  


import base.BaseTest;
import base.DriverFactory;
import config.FrameworkConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages_xpath.LoginPage_xapth;
import utils.FrameUtils;
import utils.WaitUtils;


public class LoginTest  {
	
	
	LoginPage_xapth loginPage;
	WebDriver driver;
	
	
	

    @Given("the user launches the application")
    public void the_user_launches_the_application() {
    	DriverFactory.getDriver().get(FrameworkConfig.getorangeHrmUrl());	
        
    }

    @Then("Enter the cardiential {string} and {string}")
    public void enter_the_user_name(String username,String password) {
    	loginPage = new LoginPage_xapth(DriverFactory.getDriver());
        loginPage.enter_user(username, password);
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.login();
    }

    @Then("the user should see the dashboard")
    public void the_user_should_see_the_dashboard() {
    	loginPage.verfy_dashbord();
     
    }

    @Then("the user error message {string}")
    public void the_user_error_message(String expectedMessage) {
    	loginPage.error_message();
    }
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

