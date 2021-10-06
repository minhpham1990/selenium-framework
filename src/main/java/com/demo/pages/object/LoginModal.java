package com.demo.pages.object;

import com.demo.action.ActionGen;
import com.demo.pages.ui.LoginModalUI;
import org.openqa.selenium.WebDriver;

public class LoginModal extends ActionGen {
    private WebDriver pageDriver;

    public LoginModal(WebDriver driver) {
        this.pageDriver = driver;
    }

    public void enterUsername(String value){
        enterText(pageDriver, LoginModalUI.USERNAME_SELECTOR, value);
    }

    public void enterPassword(String value){
        enterText(pageDriver, LoginModalUI.PASSWORD_SELECTOR, value);
    }

    public void clickLoginBtn(){
        click(pageDriver, LoginModalUI.SUBMIT_SELECTOR);
    }

    public void clickCancelBtn(){
        click(pageDriver, LoginModalUI.CANCEL_SELECTOR);
    }
}
