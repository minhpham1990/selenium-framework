package testcase.login;

import com.demo.action.ActionGen;
import com.demo.pages.object.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testcase.common.BaseTest;

public class TC_Login_01 extends BaseTest {

    @Test
    public void login01(){
        WebDriver browser = getDriver();
        HomePage homePage = new HomePage(browser);
        homePage.openPage();
        homePage.topmenu().clickLoginMenu();
        homePage.sleep(2000);
    }

    @Test
    public void login02(){
        WebDriver browser = getDriver();
        HomePage homePage = new HomePage(browser);
        homePage.openPage();
        homePage.topmenu().clickSignupMenu();
        homePage.sleep(2000);
    }
}
