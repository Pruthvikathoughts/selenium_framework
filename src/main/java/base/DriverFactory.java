package base;

import config.ConfigReader;
import config.FrameworkConfig;
import enums.BrowserType;
import enums.RunMode;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        if (getDriver() != null) return; // already initialized

        RunMode runMode = RunMode.valueOf(FrameworkConfig.getRunMode().toUpperCase());
        BrowserType browserType = BrowserType.valueOf(FrameworkConfig.getBrowser().toUpperCase());

        switch (runMode) {

        case LOCAL:
            driver.set(createLocalDriver(browserType));
            break;

        case GRID:
            driver.set(createGridDriver(browserType));
            break;

        case CLOUD:
            driver.set(createCloudDriver(browserType));
            break;

        default:
            throw new IllegalArgumentException("Invalid run mode: " + runMode);
    }


        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(FrameworkConfig.getImplicitWait()));
        getDriver().manage().window().maximize();
    }

    private static WebDriver createLocalDriver(BrowserType browserType) {

        switch (browserType) {

        case CHROME:
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Headless mode support
            if (FrameworkConfig.isHeadless()) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }

            // --- Anti bot detection flags ---
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);

            // User-Agent spoofing
            options.addArguments(
                    "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                    "(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
            );

            // Allow cross origin & security bypass (needed for some sites)
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            WebDriver chromeDriver = new ChromeDriver(options);

            // Remove webdriver fingerprint
            ((JavascriptExecutor) chromeDriver).executeScript(
                    "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
            );

            return chromeDriver;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
    }


    private static WebDriver createGridDriver(BrowserType browserType) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browserType.name().toLowerCase());
        try {
            return new RemoteWebDriver(new URL(FrameworkConfig.getGridUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL", e);
        }
    }

    private static WebDriver createCloudDriver(BrowserType browserType) {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Example for BrowserStack (you can adapt for SauceLabs)
        caps.setCapability("browserName", browserType.name().toLowerCase());
        caps.setCapability("os", ConfigReader.get("cloud.os"));
        caps.setCapability("osVersion", ConfigReader.get("cloud.osVersion"));
        caps.setCapability("project", ConfigReader.get("cloud.project"));
        caps.setCapability("build", ConfigReader.get("cloud.build"));
        caps.setCapability("name", ConfigReader.get("cloud.name"));

        try {
            return new RemoteWebDriver(new URL(FrameworkConfig.getCloudUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Cloud URL", e);
        }
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
