package com.demo.driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;


public class DriverFactory {
    private WebDriver driver;

    public WebDriver getDriver() {
        if(driver==null){
            driver = DriverManage.getBrowserDriver();
        }
        return driver;
    }

    public WebDriver getDriver(String browserName) {
        if(driver==null){
            driver = DriverManage.getBrowserDriver(browserName);
        }
        return driver;
    }

    public WebDriver getRemmoteDriver(DriverType type) {
        if(driver==null){
            driver = DriverManage.getRemoteDriver(type);
        }
        return driver;
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
