package cucumberTests;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/cucumberTests/login.feature",
        glue = {"cucumberTests", "hooks", "testngTests_stepdefination"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
