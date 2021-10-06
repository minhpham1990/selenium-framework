package testcase.common;

import com.demo.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.*;

public class BaseTest {
    private static ThreadLocal<DriverFactory> driverThread = new ThreadLocal<>();
    private static List<DriverFactory> webdriverThreadPool = Collections.synchronizedList(new ArrayList<>());

    public WebDriver getDriver(){
        return driverThread.get().getDriver();
    }

    @BeforeSuite(alwaysRun = true)
    public void initWebdriverObject(){
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webDriverThread = new DriverFactory();
            webdriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    @AfterSuite(alwaysRun = true)
    public void quitDriver(){
        for(DriverFactory driver:webdriverThreadPool){
            driver.quit();
        }
    }


}
