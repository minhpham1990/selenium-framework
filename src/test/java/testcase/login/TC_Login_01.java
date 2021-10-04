package testcase.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testcase.common.BaseTest;

public class TC_Login_01 extends BaseTest {

    @Test
    public void login01(){
        WebDriver browser = getDriver();
        browser.get("https://www.demoblaze.com/index.html");
    }
}
