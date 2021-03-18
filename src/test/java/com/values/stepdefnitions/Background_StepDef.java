package com.values.stepdefnitions;

import com.values.pageobject.LoginPage;
import com.values.utilites.WebLibraryUtilites;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Background_StepDef {

	public LoginPage loginpage;
	public WebLibraryUtilites lib;

	public Background_StepDef() {
		this.loginpage = new LoginPage();
		lib = new WebLibraryUtilites();

	}

	@Given("User naviagte to value app")
	public void user_naviagte_to_exercise_app() {
		this.loginpage.navigateTo();
	}

	@When("user enters userid and password")
	public void user_enters_userid_and_password() {
		loginpage.Login("abc", "xyz");

	}

	@Then("user click on login button")
	public void user_click_on_login_button() {
		lib.click(loginpage.getBtnLogin(), "Login Button");

	}

	@Then("User navigated to values page")
	public void user_navigated_to_dashboard_screen() {
		loginpage.getHomepage_Header().isDisplayed();
	}

}
