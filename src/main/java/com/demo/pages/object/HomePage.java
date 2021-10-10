package com.demo.pages.object;

import com.demo.action.ActionGen;
import com.demo.pages.component.TopMenu;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    public TopMenu getTopmenu(){
        return new TopMenu(pageDriver);
    }

    public void openPage(){
        navigate(pageDriver,"https://www.demoblaze.com/index.html");
    }

}
