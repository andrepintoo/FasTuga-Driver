Feature: US5 - Logout
  As a user
  I want to logout from the application

  Scenario: Check Logout Button Exists
    Given the user opens the application
    	And the user is logged in
    When the user clicks on the "Menu" in the navbar
    Then the user sees the "Logout" text in the Menu
    
   Scenario: Check Successful Logout
   	Given the user opens the application
    	And the user is logged in
    When the user clicks on the "Menu" in the navbar
    	And the user clicks on the "Logout" text in the Menu
    Then the user sees the "LOGIN" screen