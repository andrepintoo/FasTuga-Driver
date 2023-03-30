$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/André/Katalon Studio/taes22_grupow_fastugadriver_tests.git/Include/features/us8emptyorders.feature");
formatter.feature({
  "name": "US8 - Assign Order",
  "description": "  \tAs a user\n    I want to be able to accept an order\n    So that it starts to be prepared for the delivery",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check Empty Available Orders",
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
  "name": "the user sees that the \"No orders Available\" text exists",
  "keyword": "Then "
});
formatter.match({
  "location": "CancelOrderTests.the_user_verifies_text_exists(String)"
});
formatter.result({
  "status": "passed"
});
});