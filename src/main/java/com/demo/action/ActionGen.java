package com.demo.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionGen {
    public void navigate(WebDriver driver, String url){
        driver.get(url);
    }

    public WebElement findElement(WebDriver driver, By locator){
        return driver.findElement(locator);
    }

    public void enterText(WebDriver driver, By locator, String text){
        WebElement e = findElement(driver,locator);
        e.clear();
        e.sendKeys(text);
    }

    public void click(WebDriver driver, By locator){
        WebElement e = findElement(driver,locator);
        e.click();
    }

    public void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
