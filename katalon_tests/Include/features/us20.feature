Feature: US20 - Check My Balance
  As a user
  I want to be able to check my balance

	Background:
		Given the user opens the application
			And the user is logged in
	
	Scenario: Check Balance Value Exists
		Then the user can see that the "Balance Text Label" exists
			And the user can see that the "Balance Value" has a number
	
	#To test this following scenario you must have the first order in the Assigned Orders List with the 'Delivering' status
  
  Scenario: Check Balance Value Updates After Delivery
  		And the user sees the Assigned Orders list
	 		And the user sees the Balance value
	  When the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
	  	And the user sees how much he is going to earn for that delivery
			And the user clicks on the "Delivered" button
		Then the user sees that the balance has gone up