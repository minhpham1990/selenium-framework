package testcase.login;


import com.demo.entity.Credential;
import com.demo.pages.object.HomePage;
import com.demo.pages.object.LoginModal;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testcase.common.BaseTest;

import java.io.File;

public class TC_Login_With_JsonData01 extends BaseTest {
    HomePage homePage;
    LoginModal loginModal;
    private WebDriver driver;
    @BeforeClass
    public void setupTestCase(){
        driver = getDriver();
    }

    @Test(description = "Login with valid user using json data")
    public void login02(){
        Credential data = Credential.get("src/test/data/TC_Login_With_JsonData01.json");
        homePage = new HomePage(driver);
        homePage.openPage();
        homePage.getTopmenu().clickLoginMenu();
        loginModal = new LoginModal(driver);
        loginModal.loginValidCred(data.getUserName(),data.getPassword());
        homePage.sleep(3000);
        homePage.getTopmenu().clickLogoutMenu();
        homePage.sleep(2000);
    }

}
