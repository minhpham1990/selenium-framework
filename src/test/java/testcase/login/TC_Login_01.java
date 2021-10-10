package testcase.login;

import com.demo.constants.MyConstant;
import com.demo.driver.DriverType;
import com.demo.pages.object.HomePage;
import com.demo.pages.object.LoginModal;
import com.demo.utils.ExcelReader;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcase.common.BaseTest;

import java.io.File;

public class TC_Login_01 extends BaseTest {
    HomePage homePage;
    LoginModal loginModal;
    private WebDriver driver;
    @BeforeClass
    public void setupTestCase(){
        driver = getDriver();
    }

    @Test(dataProvider = "login01.data") //using testdata Excel
    public void login01(String user, String pass){
        homePage = new HomePage(driver);
        homePage.openPage();
        homePage.getTopmenu().clickLoginMenu();
        loginModal = new LoginModal(driver);
        loginModal.loginValidCred(user, pass);
        homePage.sleep(2000);
        homePage.getTopmenu().clickLogoutMenu();
        homePage.sleep(2000);
    }

//    @Test(dataProvider = "login01.data")
//    public void login02(){
//        homePage = new HomePage(driver);
//        homePage.openPage();
//        homePage.getTopmenu().clickLoginMenu();
//        loginModal = new LoginModal(driver);
//        homePage.sleep(2000);
//    }

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
