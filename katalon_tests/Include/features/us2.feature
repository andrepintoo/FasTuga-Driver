Feature: Register
  As a user
	I want to be able to register to the aplication
	So that I can authenticate myself

	Background:
		Given the user opens the application
			And the user clicks on the "REGISTER" button
			And the user sees the "REGISTER" screen

	Scenario: Go to Login Screen
		When the user clicks on the "back to login register" button
		Then the user sees the "LOGIN" text

	Scenario: Check Successful Register
		When the user fills the "first name register" field with "John"
		     And the user fills the "last name register" field with "Doe"
		     And the user fills the "email register" field with "johndoe@email.pt"
		     And the user fills the "password register" field with "password"
		     And the user fills the "password confirmation register" field with "password"
		     And the user fills the "phone number register" field with "999888777"
		     And the user fills the "license plate register" field with "AA-11-AA"
		     And the user clicks on the "register from register" button
		Then the user sees the "Welcome" screen

	Scenario: Check Register With Existing License Plate
		When the user fills the "license plate register" field with "AA-00-AA"
				 And the user clicks on the "register from register" button
		Then the user sees the "License plate already exists!" error text in the "existing license plate register" field
		
	Scenario: Check Register With Invalid License Plate Format
		When the user fills the "license plate register" field with "AA-ZZ-AA"
				 And the user clicks on the "register from register" button
		Then the user sees the "Wrong License Format - AA-00-AA." error text in the "invalid license plate register" field
		
	Scenario: Check Register With Existing Email
		When the user fills the "email register" field with "sara@mail.pt"
				 And the user clicks on the "register from register" button
		Then the user sees the "Email already exists!" error text in the "existing email register" field

	Scenario: Check Register With Mismatch Passwords
		When the user fills the "password register" field with "password"
				And the user fills the "password confirmation register" field with "paswordddd"
				And the user clicks on the "register from register" button
		Then the user sees the "Passwords don't match." error text in the "mismatch password register" field
		
	Scenario: Check Register With Empty Fields
		When the user clicks on the "register from register" button
		Then the user sees the "Enter First Name." error text in the "first name register" field
				 And the user sees the "Enter Last Name." error text in the "last name register" field
				 And the user sees the "Enter Email." error text in the "email register" field
				 And the user sees the "Enter Password." error text in the "password register" field
				 And the user sees the "Enter Password Confirmation." error text in the "password confirmation register" field
				 And the user sees the "Enter Phone Number." error text in the "phone number register" field
				 And the user sees the "Enter License Plate." error text in the "license plate register" field
		
	Scenario: Check Register With Invalid Phone Number Format
		When the user fills the "phone number register" field with "199888777"
		     And the user clicks on the "register from register" button
		Then the user sees the "Wrong Phone Number Format - 9xxxxxxxx." error text in the "invalid phone number register" field
			
	Scenario: Check Register With Invalid Email Format
		When the user fills the "email register" field with "abc.pt"
				 And the user clicks on the "register from register" button
		Then the user sees the "Wrong Email Format - AA@BB.CC." error text in the "invalid email register" field

 