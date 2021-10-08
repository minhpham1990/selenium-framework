package com.demo.driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;


public class DriverFactory {
    private WebDriver driver;

    public WebDriver getDriver(DriverType type) {
        if(driver==null){
            driver = DriverManage.getBrowserDriver(type);
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
