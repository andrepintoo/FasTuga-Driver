Feature: US1 - Login
  As a user
    I want to authenticate myself
    So that I can access the application
    
  Background:
  	Given the user opens the application

  Scenario: Check Login Exists    
    Then the user sees the "LOGIN" screen
    
	Scenario: Check Login With Empty Fields
			And the user sees the "LOGIN" screen
		When the user clicks on the "LOGIN" button
		Then the user sees the "Email field cannot be empty" error text in "empty email login" field
			And the user sees the "Password field cannot be empty" error text in "empty password login" field

	Scenario: Check Login With Invalid Email Format
			And the user sees the "LOGIN" screen
		When the user fills the "email login" field with "abc.pt"
			And the user clicks on the "LOGIN" button
		Then the user sees the "Wrong email format" error text in "invalid email login" field

	Scenario: Go to Register Screen From Login
			And the user sees the "LOGIN" screen
		When the user clicks on the "REGISTER" button
		Then the user sees the "REGISTER" text
		
	Scenario Outline: Check Successful Authentication
			And the user sees the "LOGIN" screen
			And the user fills the email field with <email>
			And the user fills the password field with <password>
			And the user clicks on the "LOGIN" button
			Then the user sees the "Welcome" text
			
			Examples:
				| email | password |
				| contacto@email.pt | password |
				| rodrigo.campos@mail.pt | 12345678 |
				
	Scenario Outline: Check Login With Invalid Credentials
			And the user sees the "LOGIN" screen
			And the user fills the email field with <email>
			And the user fills the password field with <password>
			And the user clicks on the "LOGIN" button
			Then the user sees the "Wrong Credentials" text
			
			Examples:
				| email | password |
				| abc@email.pt | 123456789 |
				| utilizador@email.pt | admin |
			
	#Scenario: Check Successful Authentication
		#	And the user sees the "LOGIN" screen
		#When the user fills the "email login" field with "contacto@email.pt"
		#	And the user fills the "password login" field with "password"
		#	And the user clicks on the "LOGIN" button
		#Then the user sees the "Welcome" screen
		
		#Scenario: Check Login With Invalid Credentials
	#		And the user sees the "LOGIN" screen
	#	When the user fills the "email login" field with "abc@email.pt"
	#		And the user fills the "password login" field with "123456789"
	#		And the user clicks on the "LOGIN" button
	#	Then the user sees the "Wrong Credentials" text
	
	