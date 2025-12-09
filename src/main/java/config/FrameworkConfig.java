package config;

import java.util.List;

import com.google.gson.annotations.SerializedName;



public class FrameworkConfig {

    public static String getRunMode() {
        return ConfigReader.get("runMode");
    }

    public static String getBrowser() {
        return ConfigReader.get("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(ConfigReader.get("headless"));
    }

    public static String getGridUrl() {
        return ConfigReader.get("grid.url");
    }

    public static String getCloudUrl() {
        return ConfigReader.get("cloud.url");
    }

    public static String getCloudProvider() {
        return ConfigReader.get("cloud.provider");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(ConfigReader.get("implicitWait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(ConfigReader.get("explicitWait"));
    }

    public static String getAmazonUrl() {
        return ConfigReader.get("amazon.url");
    }

    public static String getAlertsUrl() {
        return ConfigReader.get("demoAlerts.url");
    }

    public static String getFramesUrl() {
        return ConfigReader.get("demoFrames.url");
    }

   
    public static String getNaukriUrl() {
        return ConfigReader.get("naukriUrl");
    }
        
     public static String getorangeHrmUrl(){
    	 return ConfigReader.get("orangeHrm");
    	 
     }
     
     
    	
    	 
    
    }

