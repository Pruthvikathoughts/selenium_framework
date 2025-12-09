package hooks;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

  
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            

            // Attach screenshot to Cucumber scenario,
            // Allure will automatically show it
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
       
            DriverFactory.quitDriver();
        
        
        
     
    
    }
    
    

    
    
}
