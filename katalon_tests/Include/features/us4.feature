Feature: US4 - Order Details
  As a user
	I want to open the order details
	So that I can check the order information
	
	Background:
	Given the user opens the application
		And the user logs in the application
		And the user sees the Available Orders list
	When the user clicks on one of the orders in the Available Orders list

  Scenario: Check Order Details Screen Exists
    Then the user sees the "Order Details" screen
        
   Scenario: Check Order information
    Then the user sees the "Order Details" screen 
    	And the user sees the "8438" text in "Order Number" field
    	And the user sees the "Customer 2" text in "Client Name" field
    	And the user sees the "+351 220136359" text in "Client Phone" field
    	And the user sees the "Rua Afonso Lopes Vieira, Leiria" text in "Location" field
    	And the user sees the "2.37 Km" text in "Distance" field
    	And the user sees the "2 €" text in "Earning" field
    	
        
   Scenario: Go Back
    And the user clicks on the "BACK to available orders" button
		Then the user sees the "Welcome" screen