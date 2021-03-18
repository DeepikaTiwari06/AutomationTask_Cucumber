Feature: Verify count and sum of values that appear on screen

Background: User logged in Values Page
Given User naviagte to value app
When user enters userid and password
Then user click on login button
Then User navigated to values page
 
  Scenario: Values page validation 
    When User navigated to values screen 
    Then Verify number of fields 6 values appears on value page
    And Verify values on value page is greater than 0
    And Verify total balance is accurate as per the values on the screen
    And Verify the currency format of the values
    And Verify total balance matches with the sum of the values amount