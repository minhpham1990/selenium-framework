package com.demo.driver;

import org.openqa.selenium.WebDriver;


public class DriverFactory {
    private WebDriver driver;

    public WebDriver getDriver() {
        if(driver==null){
            driver = DriverManage.getBrowserDriver("firefox");
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
