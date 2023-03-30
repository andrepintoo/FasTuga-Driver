$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/UCs_5th_Semester/TA_EngenhariaSoftware/Projeto/taes22_grupow_fastugadriver_tests.git/include/features/us3.feature");
formatter.feature({
  "name": "Register",
  "description": "\tAs a user\n\tI want to access the Orders Screen\n\tSo that I can see all available orders",
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
  "name": "Check Available Orders Screen Exists",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user sees the \"Available Orders List\" list",
  "keyword": "Then "
});
formatter.match({
  "location": "AvailableOrdersTests.the_user_sees_the_list(String)"
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
  "name": "Check Empty Available Orders",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user sees the \"No orders Available\" text",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_text(String)"
});
formatter.result({
  "status": "passed"
});
});