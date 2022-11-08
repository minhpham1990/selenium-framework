package com.demo.action;

import com.demo.driver.DriverFactory;
import com.demo.logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import java.time.Duration;


public class ActionGen {
//    private static WebDriver actionDriver;
    private static ThreadLocal<WebDriver> actionDriver = new ThreadLocal<>();
    private static Actions action;
    private static Select select;
    private static WebDriverWait wait;
    private static JavascriptExecutor js;
    private final int defaultTimeoutWait = 10;
    private final int timeoutWaitForPageLoaded = 20;

    public ActionGen(WebDriver driver){
        this.actionDriver.set(driver);
        js = (JavascriptExecutor) actionDriver.get();
        action = new Actions(actionDriver.get());
    }
    public static WebDriver getActionDriver(){
        return actionDriver.get();
    }

    /* Page action */
    public static void navigate( String url){
        MyLogger.logInfo("Navigate to: "+url);
        getActionDriver().get(url);
    }

    public static void sleep(final long millis) {
        try {
            MyLogger.logInfo("Sleeep browser: "+millis);
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    /* Page action */

    /* Element action */
    public static WebElement findElement(By locator){
        return getActionDriver().findElement(locator);
    }

    public static void enterText(By locator, String text){
        MyLogger.logInfo("Enter value: "+text);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
    }

    public static void click(By locator){
        MyLogger.logInfo("Click element: "+locator);
        waitElementVisible(locator, 5);
        waitElementToBeClickable(locator,10);
        findElement(locator).click();
    }
    /* Element action */

    /* My Alert*/
    public static void alertAccept(){
        wait = new WebDriverWait(getActionDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        getActionDriver().switchTo().alert().accept();
    }

    public static void alertDismiss(){
        wait = new WebDriverWait(getActionDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        getActionDriver().switchTo().alert().dismiss();
    }
    /* My Alert  */

    /* My Waits */
    public static void waitElementVisible(By selector, long timeout){ //make sure element is displayed on UI
        MyLogger.logInfo("Start wait for element to be visible"+selector);
        wait = new WebDriverWait(getActionDriver(), Duration.ofSeconds(timeout));
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        }catch (Exception e){
            MyLogger.logError("Element is not visible");
            throw new TestException(e);
        }

    }

    public static void waitElementPresence(By selector, long timeout){ //make sure element is existed on DOM , maybe displayed/ undisplayed on UI
        MyLogger.logInfo("Start wait for element to be visible"+selector);
        wait = new WebDriverWait(getActionDriver(), Duration.ofSeconds(timeout));
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        }catch (Exception e){
            MyLogger.logError("Element is not presence");
            throw new TestException(e);
        }

    }

    public static void waitElementToBeClickable(By selector, long timeout){
            MyLogger.logInfo("Start wait for element to be clickable"+selector);
            wait = new WebDriverWait(getActionDriver(), Duration.ofSeconds(timeout));
            try{
                wait.until(ExpectedConditions.elementToBeClickable(selector));
            }catch (Exception e){
                MyLogger.logError("Element cannot clickable");
                throw new TestException(e);
            }

    }
    /* My Waits */

}
