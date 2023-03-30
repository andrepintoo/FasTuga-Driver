$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/André/Katalon Studio/taes22_grupow_fastugadriver_tests.git/Include/features/us8.feature");
formatter.feature({
  "name": "US8 - Assign Order",
  "description": "  \tAs a user\n    I want to be able to accept an order\n    So that it starts to be prepared for the delivery",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check Assign Button Exists",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user opens the application",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginTests.the_user_opens_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in the application",
  "keyword": "And "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_logs_in_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the Available Orders list",
  "keyword": "And "
});
formatter.match({
  "location": "AssignOrderTests.the_user_sees_the_available_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on one of the orders in the Available Orders list",
  "keyword": "When "
});
formatter.match({
  "location": "AssignOrderTests.the_user_clicks_the_order_in_the_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Order Details\" screen",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Assign\" button",
  "keyword": "And "
});
formatter.match({
  "location": "CancelOrderTests.the_user_sees_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Assigned Order By Clicking Assign Button",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user opens the application",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginTests.the_user_opens_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in the application",
  "keyword": "And "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_logs_in_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the Available Orders list",
  "keyword": "And "
});
formatter.match({
  "location": "AssignOrderTests.the_user_sees_the_available_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on one of the orders in the Available Orders list",
  "keyword": "When "
});
formatter.match({
  "location": "AssignOrderTests.the_user_clicks_the_order_in_the_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Assign\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the Available Orders list",
  "keyword": "Then "
});
formatter.match({
  "location": "AssignOrderTests.the_user_sees_the_available_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees that the assigned order item is not in the Available Orders list",
  "keyword": "And "
});
formatter.match({
  "location": "AssignOrderTests.the_user_verifies_order_item_missing_in_available_orders()"
});
formatter.result({
  "status": "passed"
});
});