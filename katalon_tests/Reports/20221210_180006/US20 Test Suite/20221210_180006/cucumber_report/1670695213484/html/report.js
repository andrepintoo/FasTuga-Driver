$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/André/Katalon Studio/taes22_grupow_fastugadriver_tests.git/Include/features/us20.feature");
formatter.feature({
  "name": "US20 - Check My Balance",
  "description": "  As a user\n  I want to be able to check my balance",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
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
  "name": "the user is logged in",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Balance Value Exists",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user can see that the \"Balance Text Label\" exists",
  "keyword": "Then "
});
formatter.match({
  "location": "CheckMyBalanceTests.the_user_see_label_exists(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user can see that the \"Balance Value\" has a number",
  "keyword": "And "
});
formatter.match({
  "location": "CheckMyBalanceTests.the_user_see_number(String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
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
  "name": "the user is logged in",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Balance Value Updates After Delivery",
  "description": "",
  "keyword": "Scenario"
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
  "name": "the user sees the Balance value",
  "keyword": "And "
});
formatter.match({
  "location": "CompleteHandoverTests.the_user_verifies_previous_value()"
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
  "name": "the user sees how much he is going to earn for that delivery",
  "keyword": "And "
});
formatter.match({
  "location": "CompleteHandoverTests.the_user_verifies_earnings_from_delivery()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Delivered\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees that the balance has gone up",
  "keyword": "Then "
});
formatter.match({
  "location": "CompleteHandoverTests.the_user_verifies_balance()"
});
formatter.result({
  "status": "passed"
});
});