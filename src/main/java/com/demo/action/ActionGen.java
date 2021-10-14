package com.demo.action;

import com.demo.logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionGen {
    private WebDriver actionDriver;
    private Actions action;
    private Select select;
    private WebDriverWait wait;
    private static JavascriptExecutor js;
    private final int timeoutWait = 10;
    private final int timeoutWaitForPageLoaded = 20;

    public ActionGen(WebDriver driver){
        this.actionDriver=driver;
        wait = new WebDriverWait(driver, timeoutWait);
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    public void navigate( String url){
        MyLogger.logInfo("Navigate to: "+url);
        actionDriver.get(url);
    }

    public WebElement findElement(By locator){
        return actionDriver.findElement(locator);
    }

    public void enterText(By locator, String text){
        WebElement e = findElement(locator);
        MyLogger.logInfo("Enter value: "+text);
        e.clear();
        e.sendKeys(text);
    }

    public void click(By locator){
        WebElement e = findElement(locator);
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
