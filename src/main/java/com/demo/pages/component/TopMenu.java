package com.demo.pages.component;

import com.demo.action.ActionGen;
import com.demo.pages.ui.common.TopMenuUI;
import org.openqa.selenium.WebDriver;

public class TopMenu extends ActionGen {
    private WebDriver pageDriver;

    public TopMenu(WebDriver driver) {
        this.pageDriver = driver;
    }

    public void clickHomeMenu(){
        click(pageDriver, TopMenuUI.TOPMENU_HOME);
    }

    public void clickContactMenu(){
        click(pageDriver, TopMenuUI.TOPMENU_CONTACT);
    }

    public void clickAboutMenu(){
        click(pageDriver, TopMenuUI.TOPMENU_ABOUT);
    }

    public void clickLoginMenu(){
        click(pageDriver, TopMenuUI.TOPMENU_LOGIN);
    }

    public void clickSignupMenu(){
        click(pageDriver, TopMenuUI.TOPMENU_SIGNUP);
    }

    public void clickLogoutMenu(){
        click(pageDriver, TopMenuUI.TOPMENU_LOGOUT);
    }

}
