package com.demo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManage {
    private static WebDriver driver;
    private static final String rootPath = System.getProperty("user.dir");
    public static WebDriver getBrowserDriver(String browserName){
        switch (browserName){
            case "chrome":
                String driverChromePath = rootPath+"/drivers/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver",driverChromePath);
                driver = new ChromeDriver();
                break;
            case "firefox":
                String driverFFPath = rootPath+"/drivers/geckodriver.exe";
                System.setProperty("webdriver.gecko.driver",driverFFPath);
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }




}
