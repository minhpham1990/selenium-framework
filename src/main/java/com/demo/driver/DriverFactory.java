package com.demo.driver;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

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
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
