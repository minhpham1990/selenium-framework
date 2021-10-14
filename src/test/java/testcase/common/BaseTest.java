package testcase.common;

import com.demo.action.ActionGen;
import com.demo.constants.MyConstant;
import com.demo.driver.DriverFactory;
import com.demo.driver.DriverType;
import com.demo.logger.MyLogger;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class BaseTest {
    private static ThreadLocal<DriverFactory> driverThread = new ThreadLocal<>();
    private static List<DriverFactory> webdriverThreadPool = Collections.synchronizedList(new ArrayList<>());

    public WebDriver getDriver(){
        return driverThread.get().getDriver(DriverType.FIREFOX);
    }

    public WebDriver getRemoteDriver(){
        return driverThread.get().getRemmoteDriver(DriverType.FIREFOX);
    }

    @BeforeSuite(alwaysRun = true)
    public void initWebdriverObject(){
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webDriverThread = new DriverFactory();
            webdriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    @AfterMethod
    public void tearDownTestCase(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            String methodName = result.getName();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
            Date date = new Date();
            String currentDate = dateFormat.format(date);
            String screenShotPath = MyConstant.PROJECT_PATH+"/screenshots/"+methodName+"-"+currentDate+".png";
            try{
                File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile,new File(screenShotPath));
                Path path = Paths.get(screenShotPath);
                try (InputStream is = Files.newInputStream(path)){
                    Allure.addAttachment(methodName, is);
                }
            }catch (Exception e){
                e.printStackTrace();
                MyLogger.logInfo("Fail to take screenshot");
            }
        }
    }
    @AfterSuite(alwaysRun = true)
    public void quitDriver(){
        for(DriverFactory driver:webdriverThreadPool){
            driver.quit();
        }
    }


}
