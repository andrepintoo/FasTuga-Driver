$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/André/Katalon Studio/taes22_grupow_fastugadriver_tests.git/Include/features/us11.feature");
formatter.feature({
  "name": "US11 - Cancel Order",
  "description": "  \tAs a user\n    I want to be able to cancel a currently assigned order",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check Cancel Button exists",
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
  "name": "the user sees the Assigned Orders list",
  "keyword": "And "
});
formatter.match({
  "location": "CancelOrderTests.the_user_sees_the_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on one of the \"Assigned Order Item\" in the Assigned Orders list",
  "keyword": "When "
});
formatter.match({
  "location": "CancelOrderTests.the_user_clicks_the_button_in_the_list(String)"
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
  "name": "the user sees the \"Cancel\" button",
  "keyword": "And "
});
formatter.match({
  "location": "CancelOrderTests.the_user_sees_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Successful Cancel Order",
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
  "name": "the user sees the Assigned Orders list",
  "keyword": "And "
});
formatter.match({
  "location": "CancelOrderTests.the_user_sees_the_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on one of the \"Assigned Order Item\" in the Assigned Orders list",
  "keyword": "When "
});
formatter.match({
  "location": "CancelOrderTests.the_user_clicks_the_button_in_the_list(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Order Details\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Cancel\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"YES Cancel Order\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees that the clicked order item is not in the Assigned Orders list",
  "keyword": "Then "
});
formatter.match({
  "location": "CancelOrderTests.the_user_verifies_order_item_missing()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Welcome\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
});