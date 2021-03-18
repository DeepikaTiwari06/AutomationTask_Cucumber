package com.values.utilites;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetupUtilites {

    public static WebDriver driver;
    public PropertyUtilites prop=new PropertyUtilites();

    @Before
    public void setWebDriver() throws Exception {
        String browser = prop.getbrower();
        if (browser == null) {
            browser = "chrome";
        }
       if(browser.equals("chrome")) {
          
            	System.setProperty("webdriver.chrome.driver",prop.getdriverpath());
            	ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("['start-maximized']");
                driver = new ChromeDriver(chromeOptions);
                System.out.println("Chrome Driver");
       }
        else if (browser.equals( "firefox")){
        	
                driver = new FirefoxDriver();
        }else {
        	 throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        
        }  
             
              driver.manage().window().maximize();
  
    }
    
    @After
    public void quitDriver(Scenario scenario){
        if(scenario.isFailed()){
           saveScreenshotsForScenario(scenario);
        }
       driver.quit();
    }

    @SuppressWarnings("deprecation")
	private void saveScreenshotsForScenario(final Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
}
