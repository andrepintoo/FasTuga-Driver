Feature: US21 - See And Change My Profile Details
  As a user
  I want to opt out from the application
  
  #To test this scenario: you must use a user of the Database.
  
  Background:
		Given the user opens the application
			And the user fills the "email login" field with "rodrigo.campos@mail.pt"
			And the user fills the "password login" field with "12345678"
			And the user clicks on the "LOGIN" button
  	When the user clicks on the "Menu" in the navbar
  	
  	Scenario: Check Profile Button Exists
    	Then the user sees the "Profile" text in the Menu
    
    Scenario: Check User Profile Details Exist
    	Then the user clicks on the "Profile" text in the Menu
    		And the user sees that the "Profile Name" text is not empty
    		And the user sees that the "Profile Email" text is not empty
    	
    Scenario: Check Change Password Button Exists
    		And the user clicks on the "Profile" text in the Menu
	    Then the user sees the "CHANGE PASSWORD Profile" button
    	
    Scenario: Check Change Name Button Exists
    		And the user clicks on the "Profile" text in the Menu
	    Then the user sees the "CHANGE NAME Profile" button
    
    Scenario: Go to Change Password Screen
	    	And the user clicks on the "Profile" text in the Menu
				And the user clicks on the "CHANGE PASSWORD Profile" button
			Then the user sees the "Change My Password" text
			
		Scenario: Go Back to Profile Screen in Change Password Screen
	    	And the user clicks on the "Profile" text in the Menu
				And the user clicks on the "CHANGE PASSWORD Profile" button
			Then the user clicks on the "BACK Change Password" button
    		And the user sees that the "Profile Name" text is not empty
    		And the user sees that the "Profile Email" text is not empty
			
		Scenario: Check Change Password Button Exists
    		And the user clicks on the "Profile" text in the Menu
				And the user clicks on the "CHANGE PASSWORD Profile" button
	    Then the user sees the "CHANGE PASSWORD Change" button
		
		#To test this scenario: you must login with the new password
		
		Scenario: Check Successful Change Password
				And the user clicks on the "Profile" text in the Menu
				And the user clicks on the "CHANGE PASSWORD Profile" button
				And the user fills the "Atual Password" field with "12345678"
		    And the user fills the "New Password" field with "password"
		    And the user fills the "Confirm Password" field with "password"
		    And the user clicks on the "CHANGE PASSWORD Change" button
			Then the user sees the Confirmation Dialog "Success"
				And the user clicks on the "Success OK" button
	  	  And the user clicks on the "Menu" in the navbar
    		And the user clicks on the "Logout" text in the Menu
    		And the user sees the "LOGIN" screen
    		And the user fills the "email login" field with "rodrigo.campos@mail.pt"
				And the user fills the "password login" field with "password"
				And the user clicks on the "LOGIN" button
				And the user sees the "Welcome" screen
		
		Scenario: Go to Change Name Screen
	    	And the user clicks on the "Profile" text in the Menu
				And the user clicks on the "CHANGE NAME Profile" button
			Then the user sees the "Change Name" text
			
			Scenario: Go Back to Profile Screen in Change Name Screen
	    	And the user clicks on the "Profile" text in the Menu
				And the user clicks on the "CHANGE NAME Profile" button
			Then the user clicks on the "BACK Change Name" button
    		And the user sees that the "Profile Name" text is not empty
    		And the user sees that the "Profile Email" text is not empty
			
		Scenario: Check Change Name Button Exists
    		And the user clicks on the "Profile" text in the Menu
				And the user clicks on the "CHANGE NAME Profile" button
	    Then the user sees the "CHANGE NAME Change" button

		Scenario: Check Successful Change Name
				And the user clicks on the "Profile" text in the Menu
				And the user clicks on the "CHANGE NAME Profile" button
				And the user fills the "First Name Change" field with "MARIO"
		    And the user fills the "Last Name Change" field with "ANTUNES"
		    And the user clicks on the "CHANGE NAME Change" button
			Then the user sees the Confirmation Dialog "Success"
				And the user clicks on the "Success OK" button
				And the user sees that the "Profile Name" text equals "MARIO ANTUNES"
			
