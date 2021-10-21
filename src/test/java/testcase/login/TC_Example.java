package testcase.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testcase.common.BaseTest;

public class TC_Example extends BaseTest {
    private static WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setupTestCase(String browser){
        driver = getDriver(browser);
    }

    @Test
    public void testcase1(){
        System.out.println("Run TC1");
        driver.get("https://www.google.com");
    }

    @Test
    public void testcase2(){
        System.out.println("Run TC1");
        driver.get("https://ban.sendo.vn/");
    }

    @Test
    public void testcase3(){
        System.out.println("Run TC1");
        driver.get("https://www.demoblaze.com/");
    }

    @Test
    public void testcase4(){
        System.out.println("Run TC1");
        driver.get("https://www.twitter.com");
    }

}
