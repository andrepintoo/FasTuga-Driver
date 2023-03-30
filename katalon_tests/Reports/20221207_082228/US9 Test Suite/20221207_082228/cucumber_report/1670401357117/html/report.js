$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/UCs_5th_Semester/TA_EngenhariaSoftware/Projeto/taes22_grupow_fastugadriver_tests.git/include/features/us9.feature");
formatter.feature({
  "name": "Claim Order",
  "description": "  As a user \n\tI want to claim an order\n\tSo that I can start my delivery",
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
formatter.step({
  "name": "the user sees the \"Assigned Orders List\" list",
  "keyword": "And "
});
formatter.match({
  "location": "AvailableOrdersTests.the_user_sees_the_list(String)"
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
formatter.scenario({
  "name": "Check Claim Button Exists",
  "description": "",
  "keyword": "Scenario"
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
  "name": "the user sees the \"Claim\" button",
  "keyword": "And "
});
formatter.match({
  "location": "CancelOrderTests.the_user_sees_the_button(String)"
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
formatter.step({
  "name": "the user sees the \"Assigned Orders List\" list",
  "keyword": "And "
});
formatter.match({
  "location": "AvailableOrdersTests.the_user_sees_the_list(String)"
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
formatter.scenario({
  "name": "Check Claimed Order By Clicking Claim Button",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user clicks on the \"Claim\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the order status switches to \" DELIVERING\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimOrderTests.the_order_status_switches_to(String)"
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