package testcase.login;

import com.demo.constants.MyConstant;
import com.demo.driver.DriverType;
import com.demo.logger.MyLogger;
import com.demo.pages.object.HomePage;
import com.demo.pages.object.LoginModal;
import com.demo.utils.ExcelReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testcase.common.BaseTest;

import java.io.File;

public class TC_Login_With_ExcelData01 extends BaseTest {
    HomePage homePage;
    LoginModal loginModal;
    private WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setupTestCase(String browser){
        driver = getDriver(browser);
    }

    @Test(dataProvider = "login01.data", description = "Login with valid user using excel data") //using testdata Excel
    @Description("Test case using data excel file , and then login with them")
    public void login01(String user, String pass){
        homePage = new HomePage(driver);
        homePage.openPage();
        homePage.getTopmenu().clickLoginMenu();
        loginModal = new LoginModal(driver);
        loginModal.loginValidCred(user, pass);
        homePage.sleep(3000);
        homePage.getTopmenu().clickLogoutMenu();
    }

    @Test(description = "Login with invalid user")
    public void login02(){
        homePage = new HomePage(driver);
        homePage.openPage();
        homePage.getTopmenu().clickLoginMenu();
        loginModal = new LoginModal(driver);
        loginModal.loginValidCred("hoho", "1123123");
        loginModal.acceptLoginAllert();
//        Assert.fail("Testscreenshot");
    }

    @DataProvider(name = "login01.data")
    public Object[][] loginData(){
        String excelFileName="login01.xlsx";
        File excelFileLocation=new File(MyConstant.PROJECT_PATH + "/src/test/data/" + excelFileName);
        System.out.println(MyConstant.PROJECT_PATH + "/src/test/data" + excelFileName);
        String sheetName = "Sheet1";
        int startRowIndex = 1;
        int startColumnIndex = 0;
        ExcelReader excelReader = new ExcelReader(excelFileLocation, sheetName, startRowIndex, startColumnIndex);
        int totalRow = excelReader.getTotalRow();
        int totalColumn = excelReader.getTotalColumn();

        Object[][] loginData = new Object[totalRow - startRowIndex][totalColumn - startColumnIndex];
        for (int startRow = startRowIndex; startRow < totalRow; startRow++) {
            for (int startColumn = startColumnIndex; startColumn < totalColumn; startColumn++) {
                loginData[startRow - startRowIndex][startColumn] = excelReader.getCellValue(startRow, startColumn);
            }
        }

        return loginData;
    }
}
