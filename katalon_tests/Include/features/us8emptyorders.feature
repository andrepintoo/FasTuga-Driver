	Feature: US8 - Assign Order
  	As a user
    I want to be able to accept an order
    So that it starts to be prepared for the delivery
    
   #To test this scenario: you must have at an empty Available Orders List

   Scenario: Check Empty Available Orders
   	Given the user opens the application
    	And the user logs in the application
    	And the user sees the Assigned Orders list
    Then the user sees that the "No orders Available" text exists