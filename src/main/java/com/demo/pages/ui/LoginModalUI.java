package com.demo.pages.ui;

import org.openqa.selenium.By;

public class LoginModalUI {
    public static final By USERNAME_SELECTOR = By.xpath("//input[@id='loginusername']");
    public static final By PASSWORD_SELECTOR = By.xpath("//input[@id='loginpassword']");
    public static final By SUBMIT_SELECTOR = By.xpath("//button[contains(text(),'Log in')]");
    public static final By CANCEL_SELECTOR = By.xpath("//body/div[@id='logInModal']/div[1]/div[1]/div[3]/button[1]");

}
