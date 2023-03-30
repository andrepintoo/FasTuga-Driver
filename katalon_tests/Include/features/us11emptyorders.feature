	Feature: US11 - Cancel Order
  	As a user
    I want to be able to cancel a currently assigned order
    
    #To test this scenario: you must have at an empty Assigned Orders List
    
   Scenario: Check Empty Assigned Orders
   	Given the user opens the application
    	And the user logs in the application
    	And the user sees the Assigned Orders list
    Then the user sees that the "No assigned Orders" text exists