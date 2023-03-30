Feature: Statistics
  As a user
	I want to see the number os assigned orders delivered
		And the total delivery time	
		And the average time per delivery
		And the balance
		And the different number of clients served
		And the average speed per delivery
	So that I can measure my performance as a driver

	#To test this scenario: must have one assigned order in the "Delivering" state
   
	Background:
		Given the user opens the application
			And the user is logged in
		When the user clicks on the "Menu" in the navbar
			And the user clicks on the "Statistics" text in the Menu

	Scenario: Check Statistics Screen Exists
		Then the user sees the "Statistics" screen

	Scenario: Check "Total Delivery Time" Field Exists
		Then the user sees the "total delivery time statistics" field

	Scenario: Check "Average Time Per Delivery" Field Exists
		Then the user sees the "average time per delivery statistics" field

	Scenario: Check "Balance" Field Exists
		Then the user sees the "balance statistics" field	

	Scenario: Check "Clients Served" Field Exists
		Then the user sees the "clients served statistics" field

	Scenario: Check "Average Speed Per Delivery" Field Exists
		Then the user sees the "average speed per delivery statistics" field
		
	Scenario: Check "Assigned Orders Delivered" Field Exists
		Then the user sees the "assigned orders delivered statistics" field

	Scenario: Check Fields Updates After Order Delivered
			And the user sees the "previous" statistics values
			And the user clicks on the "Menu" in the navbar
			And the user clicks on the "Available Orders Statistics" text in the Menu
			And the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
			And the user clicks on the "Delivered" button
			And the user sees the "Welcome" screen
			And the user clicks on the "Menu" in the navbar
			And the user clicks on the "Statistics" text in the Menu
			And the user sees the "new" statistics values
		Then the user verifies that the statistics values changed
		