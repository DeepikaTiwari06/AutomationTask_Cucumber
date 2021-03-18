$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Feature/BalanceAndCountValues.feature");
formatter.feature({
  "name": "Verify count and sum of values that appear on screen",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "User logged in Values Page",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User naviagte to value app",
  "keyword": "Given "
});
formatter.match({
  "location": "com.values.stepdefnitions.Background_StepDef.user_naviagte_to_exercise_app()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters userid and password",
  "keyword": "When "
});
formatter.match({
  "location": "com.values.stepdefnitions.Background_StepDef.user_enters_userid_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on login button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.values.stepdefnitions.Background_StepDef.user_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigated to values page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.values.stepdefnitions.Background_StepDef.user_navigated_to_dashboard_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Values page validation",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User navigated to values screen",
  "keyword": "When "
});
formatter.match({
  "location": "com.values.stepdefnitions.Validation_StepDef.user_navigated_to_values_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify number of fields 6 values appears on value page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.values.stepdefnitions.Validation_StepDef.verify_count_of_fields_values_appears_on_screen(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify values on value page is greater than 0",
  "keyword": "And "
});
formatter.match({
  "location": "com.values.stepdefnitions.Validation_StepDef.verify_values_on_screen_greater_than(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify total balance is accurate as per the values on the screen",
  "keyword": "And "
});
formatter.match({
  "location": "com.values.stepdefnitions.Validation_StepDef.verify_total_balance_is_correct_based_on_values_listed_on_screen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the currency format of the values",
  "keyword": "And "
});
formatter.match({
  "location": "com.values.stepdefnitions.Validation_StepDef.verify_values_currency_format()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify total balance matches with the sum of the values amount",
  "keyword": "And "
});
formatter.match({
  "location": "com.values.stepdefnitions.Validation_StepDef.SumofTotal()"
});
formatter.result({
  "status": "passed"
});
});