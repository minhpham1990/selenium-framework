package com.demo.pages.object;

import com.demo.pages.ui.LoginModalUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginModal extends BasePage{

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    @Step("Input username as {value}") //using to display on allure report
    public void enterUsername(String value){
        enterText(LoginModalUI.USERNAME_SELECTOR, value);
    }

    @Step("Input password as {value}")
    public void enterPassword(String value){
        enterText(LoginModalUI.PASSWORD_SELECTOR, value);
    }

    @Step("Click button login")
    public void clickLoginBtn(){
        click(LoginModalUI.SUBMIT_SELECTOR);
    }

    public void clickCancelBtn(){
        click(LoginModalUI.CANCEL_SELECTOR);
    }

    public void loginValidCred(String user, String pass){
        enterUsername(user);
        enterPassword(pass);
        clickLoginBtn();
    }

    public void acceptLoginAllert(){
        alertAccept();
    }
}
