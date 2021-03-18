package com.values.basepage;

import org.openqa.selenium.WebDriver;
import com.values.utilites.SetupUtilites;
import com.values.utilites.WaitUtilites;
import com.values.utilites.WebLibraryUtilites;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtilites wait;
    protected WebLibraryUtilites lib;

    public BasePage() {
        this.driver = SetupUtilites.driver;
        this.wait = new WaitUtilites(this.driver);  
    }
    
    public WebDriver getDriver()
    {
    	return this.driver;
    }
}
