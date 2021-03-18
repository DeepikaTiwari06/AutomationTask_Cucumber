package com.values.utilites;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.values.basepage.BasePage;





public class WebLibraryUtilites extends BasePage

{

	 private WebDriver driver;
	 
	 public WebLibraryUtilites(){
		 
	  WaitUtilites wait=new WaitUtilites(driver);
	  
	 }

		/* Description:Click method used to click on element
		 * Parameter :weblement and string message
		 *  */
	public void click(WebElement element,String msg)
	{
		try {
			wait.forLoading(3);
			if(element.isDisplayed())
			{
			element.click();
			Assert.assertTrue("Able to click on"+msg +" successfully", true);
			}
			else
			{
				Assert.assertTrue("Unable to click on"+msg +" element", false);
			}
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/* Description:enter method used to enter text
	 * Parameter :weblement ,data and string message
	 *  */
	public void enter(WebElement element,String data,String msg)
	{
		try {
			wait.forLoading(3);
			if(element.isDisplayed())
			{
			element.sendKeys(data);
			Assert.assertTrue("Able to update "+msg +" field successfully", true);
			}
			else
			{
				Assert.assertTrue("Unable to update "+msg +" successfully", false);
			}
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static String replaceData(String strdata, String fromCharacter, String toCharacter) {
		String strAfterReplace = null;
		try {
			strAfterReplace = strdata.replace(fromCharacter, toCharacter);
		} catch (Exception e) {
			Reporter.log("Unable to replace value", false);
		}
		return strAfterReplace;
	}
}
