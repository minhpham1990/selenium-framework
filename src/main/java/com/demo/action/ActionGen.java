package com.demo.action;

import com.demo.logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ActionGen {

    public void navigate(WebDriver driver, String url){
        MyLogger.logInfo("Navigate to: "+url);
        driver.get(url);
    }

    public WebElement findElement(WebDriver driver, By locator){
        return driver.findElement(locator);
    }

    public void enterText(WebDriver driver, By locator, String text){
        WebElement e = findElement(driver,locator);
        MyLogger.logInfo("Enter value: "+text);
        e.clear();
        e.sendKeys(text);
    }

    public void click(WebDriver driver, By locator){
        WebElement e = findElement(driver,locator);
        MyLogger.logInfo("Click element: "+e);
        e.click();
    }

    public void sleep(final long millis) {
        try {
            MyLogger.logInfo("Sleeep browser: "+millis);
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
