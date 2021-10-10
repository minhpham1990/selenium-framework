package com.demo.pages.object;

import com.demo.action.ActionGen;
import org.openqa.selenium.WebDriver;

public class BasePage extends ActionGen {
    protected WebDriver pageDriver;

    public BasePage(WebDriver driver){
        this.pageDriver = driver;
    }
}
