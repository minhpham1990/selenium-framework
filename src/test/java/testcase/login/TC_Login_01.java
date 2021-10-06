package testcase.login;

import com.demo.pages.object.HomePage;
import com.demo.pages.object.LoginModal;
import org.testng.annotations.Test;
import testcase.common.BaseTest;

public class TC_Login_01 extends BaseTest {
    HomePage homePage;
    LoginModal loginModal;
    @Test
    public void login02(){
        homePage = new HomePage(getDriver());
        homePage.openPage();
        homePage.getTopmenu().clickLoginMenu();
        loginModal = new LoginModal(getDriver());
        loginModal.enterUsername("baminh");
        loginModal.enterPassword("123");
        loginModal.clickLoginBtn();
        homePage.sleep(2000);
    }

//    @Test
    public void login01(){
        HomePage homePage = new HomePage(getDriver());
        homePage.openPage();
        homePage.getTopmenu().clickSignupMenu();
        homePage.sleep(2000);
    }
}
