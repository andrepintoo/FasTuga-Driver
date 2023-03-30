Feature: US7 - Keep Me Logged In
  As a user
	I want to keep me login
	So that I don’t have to authenticate myself every time I want to access the application

  Scenario: Check Keep Me Logged In Checkbox Exists
    Given the user opens the application
    Then the user sees the "Keep Me Logged In" checkbox
    
  Scenario: Check Opening Application After Logout With Keep Me Signed In
 	Given the user opens the application - false
  	And the user clicks on the "Keep Me Logged In" checkbox
  	And the user logs in the application
  When the user clicks on the "Menu" in the navbar
  	And the user clicks on the "Logout" text in the Menu
  	And the user closes the application
  	And the user opens the application - false
  Then the user sees the "LOGIN" screen

	Scenario: Check Opening Application After Login With Keep Me Signed In
    Given the user opens the application - false
    	And the user clicks on the "Keep Me Logged In" checkbox
    	And the user logs in the application
    When the user closes the application
    	And the user opens the application - false
    Then the user sees the "Welcome" screen
    
   Scenario: Check Opening Application After Login Without Keep Me Signed In
   	Given the application state was reset
   		And the user opens the application - false
   		And the user sees the "LOGIN" screen
   		And the "Keep Me Logged In" checkbox is not checked
   		And the user logs in the application
   	When the user closes the application
   		And the user opens the application - false
   	Then the user sees the "LOGIN" screen
    