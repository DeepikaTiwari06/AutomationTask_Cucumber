package com.values.testrunner;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/Feature/BalanceAndCountValues.feature",
		glue = {"com.values.stepdefnitions","com.values.utilites"},
		plugin = {"pretty","html:target/HtmlReports"},
		monochrome = true
)

public class TestRunner {
}
