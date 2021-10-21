package com.demo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class DriverManage {
    private static WebDriver driver;
    private static final String rootPath = System.getProperty("user.dir");


    public static WebDriver getBrowserDriver(){
        String driverFFPath = rootPath+"/drivers/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",driverFFPath);
        return driver = new FirefoxDriver();
    }

    public static WebDriver getBrowserDriver(String browserName){
        switch (browserName.toLowerCase()){
            case "chrome":
                String driverChromePath = rootPath+"/drivers/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver",driverChromePath);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                String driverFFPath;
                if(System.getProperty("os.name").startsWith("Windows")){
                    driverFFPath= rootPath+"/drivers/geckodriver.exe";
                }else {
                    driverFFPath= rootPath+"/drivers/chromedriverLinux.exe";
                }
                System.setProperty("webdriver.gecko.driver",driverFFPath);
                driver = new FirefoxDriver(getFireFoxOptions());
                break;
        }
        return driver;
    }

    public static WebDriver getRemoteDriver(DriverType type){
        switch (type){
            case FIREFOX:
                String hub = "https://phambaminh9990:J9dSZSonFj0DjRePvcVPrY8SIWXUIffJT05JhmxL6Tpc7vTTlK@hub.lambdatest.com/wd/hub";
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("build", "my build");
                capabilities.setCapability("name", "my test name");
                capabilities.setCapability("platform", "Windows 10");
                capabilities.setCapability("browserName", "Firefox");
                capabilities.setCapability("version","92.0");
                try {
                    driver = new RemoteWebDriver(new URL(hub), capabilities);
                }catch (Exception e ){
                    e.printStackTrace();
                }
        }
        return driver;
    }

    public static FirefoxOptions getFireFoxOptions(){
        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.setHeadless(true);
        ffOptions.addPreference("browser.download.manager.focusWhenStarting", true);
        ffOptions.addPreference("browser.download.useDownloadDir", false);
        ffOptions.addPreference("browser.helperApps.alwaysAsk.force", true);
        ffOptions.addPreference("browser.download.manager.alertOnEXEOpen", false);
        ffOptions.addPreference("browser.download.manager.closeWhenDone", true);
        ffOptions.addPreference("browser.download.manager.showAlertOnComplete", false);
        ffOptions.addPreference("browser.download.manager.useWindow", false);
        ffOptions.addPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
        return ffOptions;
    }






}
