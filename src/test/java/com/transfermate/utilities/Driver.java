package com.transfermate.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "chrome_notification_handled":
                    WebDriverManager.chromedriver().setup();
                    // Create a map to store  preferences
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    // add key and value to map as follow to switch off browser notification
                    // Pass the argument 1 to allow and 2 to block
                    // 1-Allow, 2-Block, 0-default
                    prefs.put("profile.default_content_setting_values.notifications", 2);
                    //Create an instance of ChromeOptions
                    ChromeOptions options = new ChromeOptions();
                    // set ExperimentalOption - prefs
                    options.setExperimentalOption("prefs", prefs);
                    //Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver
                    // which will switch off this browser notification on the chrome browser
                    driverPool.set(new ChromeDriver(options));
                    break;
            }

        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
