	Feature: US11 - Cancel Order
  	As a user
    I want to be able to cancel a currently assigned order

	#To test this scenario: you must have exactly 2 orders with the status "Delivering" in the Driver's Assigned Orders List

  Scenario: Check Cancel Button exists
    Given the user opens the application
    	And the user logs in the application
    	And the user sees the Assigned Orders list
    When the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
    Then the user sees the "Order Details" screen
    	And the user sees the "Cancel" button
    
  Scenario: Check Successful Cancel Order
   	Given the user opens the application
    	And the user logs in the application
    	And the user sees the Assigned Orders list
    When the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
			And the user sees the "Order Details" screen
			And the user clicks on the "Cancel" button
			And the user clicks on the "YES Cancel Order" button
		Then the user sees that the clicked order item is not in the Assigned Orders list
			And the user sees the "Welcome" screen
			