Feature: US6 - Opt Out
  As a user
  I want to opt out from the application
  
  Background:
		Given the user opens the application
			And the user fills the "email login" field with "nicole.azevedo@mail.pt"
			And the user fills the "password login" field with "12345678"
			And the user clicks on the "LOGIN" button
  	When the user clicks on the "Menu" in the navbar

  Scenario: Check Opt Out Button Exists
    Then the user sees the "Opt Out" text in the Menu
        
   Scenario: Check Successful Opt Out
    	And the user clicks on the "Opt Out" text in the Menu
    	And the user sees the Confirmation Dialog "Opt Out Confirmation"
    	And the user clicks on the "Yes" button
		Then the user sees the "LOGIN" screen
        
   Scenario: Check Register with Existing Email After Opt Out
    	And the user clicks on the "Opt Out" text in the Menu
    	And the user sees the Confirmation Dialog "Opt Out Confirmation"
    	And the user clicks on the "Yes" button
			And the user sees the "LOGIN" screen
			And the user clicks on the "REGISTER" button
			And the user fills the "email register2" field with "nicole.azevedo@mail.pt"
			And the user clicks on the "REGISTER register2" button
		Then the user sees the Confirmation Dialog "Contact Administrator"