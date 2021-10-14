package com.demo.pages.component;

import com.demo.pages.object.BasePage;
import com.demo.pages.ui.common.TopMenuUI;
import org.openqa.selenium.WebDriver;

public class TopMenu extends BasePage {
    public TopMenu(WebDriver driver) {
        super(driver);
    }

    public void clickHomeMenu(){
        click(TopMenuUI.TOPMENU_HOME);
    }

    public void clickContactMenu(){
        click( TopMenuUI.TOPMENU_CONTACT);
    }

    public void clickAboutMenu(){
        click(TopMenuUI.TOPMENU_ABOUT);
    }

    public void clickLoginMenu(){
        click(TopMenuUI.TOPMENU_LOGIN);
    }

    public void clickSignupMenu(){
        click(TopMenuUI.TOPMENU_SIGNUP);
    }

    public void clickLogoutMenu(){
        click(TopMenuUI.TOPMENU_LOGOUT);
    }

}
