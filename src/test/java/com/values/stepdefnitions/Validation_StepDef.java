package com.values.stepdefnitions;

import com.values.pageobject.Valuespage;
import com.values.utilites.WebLibraryUtilites;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Validation_StepDef {

	Valuespage value = new Valuespage();
	private Valuespage valpage;
	public WebLibraryUtilites lib;

	public Validation_StepDef() {
		this.valpage = new Valuespage();
		lib = new WebLibraryUtilites();
	}

	@When("User navigated to values screen")
	public void user_navigated_to_values_screen() {
		lib.click(valpage.getLinkvalues(), "Values Link");

	}

	@Then("Verify number of fields {int} values appears on value page")
	public void verify_count_of_fields_values_appears_on_screen(Integer val) {
		value.verifyCountOnPage(val);
	}

	@Then("Verify values on value page is greater than {int}")
	public void verify_values_on_screen_greater_than(Integer val) {
		value.verifyvalueson_screen_greater_than_zero(val);

	}

	@Then("Verify total balance is accurate as per the values on the screen")
	public void verify_total_balance_is_correct_based_on_values_listed_on_screen() {
		value.verify_total_balance_is_correct_based_on_values_listed_on_screen();
	}

	@Then("Verify the currency format of the values")
	public void verify_values_currency_format() {
		value.verify_values_currency_format();
	}

	@Then("Verify total balance matches with the sum of the values amount")
	public void SumofTotal() {
		value.verifySumTotal();
	}
}
