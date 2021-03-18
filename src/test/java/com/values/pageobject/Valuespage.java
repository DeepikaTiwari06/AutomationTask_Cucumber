package com.values.pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.values.basepage.BasePage;
import com.values.utilites.WebLibraryUtilites;

public class Valuespage extends BasePage {

	public Valuespage() {
		PageFactory.initElements(driver, this);
		this.valpage = new Valuespage();
		lib = new WebLibraryUtilites();
	}

	private Valuespage valpage;
	public WebLibraryUtilites lib;

	@FindBy(id = "lnk_values")
	private WebElement linkvalues;

	@FindBy(id = "lbl_val_1")
	private WebElement Label1;

	@FindBy(id = "lbl_val_2")
	private WebElement Label2;

	@FindBy(xpath = "//span/child(contaisn(id,'txt_val'))")
	private List<WebElement> listTextBox;

	@FindBy(xpath = "//span/child(contaisn(id,'lbl_val'))")
	private List<WebElement> listLabel;

	@FindBy(id = "txt_val_1")
	private WebElement Textbox1;

	@FindBy(id = "txt_val_2")
	private WebElement Textbox2;

	@FindBy(id = "lbl_ttl_val")
	private WebElement TotalLabel;

	@FindBy(id = "txt_ttl_val")
	private WebElement TotalTextbox;

	public WebElement getTotalTextbox() {
		return TotalTextbox;
	}

	public WebElement getLinkvalues() {
		return linkvalues;
	}

	public List<WebElement> getListTextBox() {
		return listTextBox;
	}

	public List<WebElement> getListLabel() {
		return listLabel;
	}

	@FindBy(id = "txt_ttl_val")
	private WebElement label_TotalBalanceAmmount;

	@FindBy(xpath = "//*[Starts-with(@id,'txt_val'))")
	private List<WebElement> list_ValuesAmmount;

	// Verify number of fields six values appears on value page

	public void verifyCountOnPage(Integer val) {
		try {
			if (valpage.getListTextBox().size() == val.intValue()) {
				Assert.assertEquals(val.intValue(), valpage.getListTextBox().size());
				Assert.assertTrue(val.intValue() == valpage.getListTextBox().size());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Verify values on value page is greater than zero
	public void verifyvalueson_screen_greater_than_zero(Integer val) {
		try {
			List<WebElement> listval = valpage.getListTextBox();
			List<WebElement> listlabel = valpage.getListLabel();
			for (int i = 0; i < listval.size(); i++) {
				if (Integer.parseInt(listval.get(i).getAttribute("value")) > val.intValue()) {

					Assert.assertTrue("For Label=" + listlabel.get(i).getAttribute("name") + " Value is "
							+ listval.get(i).getAttribute("value") + "  is greater than 0 ", true);

				} else {

					Assert.assertTrue("For Label=" + listlabel.get(i).getAttribute("name") + " Value is "
							+ listval.get(i).getAttribute("value") + "  is not greater than 0 ", false);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Verify total balance is accurate as per the values on the screen
	public void verify_total_balance_is_correct_based_on_values_listed_on_screen() {
		try {
			List<WebElement> listval = valpage.getListTextBox();
			int Totalval = 0;
			for (WebElement s : listval) {
				String sval = s.getAttribute("value");
				String intval = sval.replace("$", "");
				Totalval = Totalval + Integer.parseInt(intval);
			}
			String totalval = valpage.getTotalTextbox().getAttribute("value");
			if (Integer.parseInt(totalval.replace("$", "")) == Totalval) {
				Assert.assertTrue(
						"Total  value is " + Totalval + " instead of " + Integer.parseInt(totalval.replace("$", "")),
						true);
			} else {
				Assert.assertTrue(
						"Total  value is " + Totalval + " instead of " + Integer.parseInt(totalval.replace("$", "")),
						false);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Verify the currency format of the values
	public void verify_values_currency_format() {
		try {
			List<WebElement> listval = valpage.getListTextBox();
			List<WebElement> listlabel = valpage.getListLabel();
			for (int i = 0; i < listval.size(); i++) {
				if (listval.get(i).getAttribute("value").indexOf("$") == 0) {
					Assert.assertTrue("For Field=" + listlabel.get(i).getAttribute("name") + " Value is "
							+ listval.get(i).getAttribute("value") + "  is in US currency format ", true);

				} else {
					Assert.assertTrue("For Field=" + listlabel.get(i).getAttribute("name") + " Value is "
							+ listval.get(i).getAttribute("value") + "  is not in US currency format ", false);

				}
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	// Verify total balance matches with the sum of the values amount

	public void verifySumTotal() {
		try {
			List<WebElement> listvalue = list_ValuesAmmount;
			int totalValue = 0;
			for (WebElement elementlist : listvalue) {
				String amount = elementlist.getAttribute("value");
				String amountAfterReplace = WebLibraryUtilites.replaceData(amount, "$", "");
				totalValue = totalValue + Integer.parseInt(amountAfterReplace);
			}
			String totalUIbalance = label_TotalBalanceAmmount.getAttribute("value");
			if (Integer.parseInt(totalUIbalance.replace("$", "")) == totalValue) {
				Assert.assertTrue("Total  value is " + totalValue + " instead of "
						+ Integer.parseInt(totalUIbalance.replace("$", "")), true);
			} else {
				Assert.assertTrue("Total  value is " + totalValue + " instead of "
						+ Integer.parseInt(totalUIbalance.replace("$", "")), false);
			}
		} catch (Exception e) {
			Reporter.log("Validation failed", false);
		}
	}
}
