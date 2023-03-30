$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/André/Katalon Studio/taes22_grupow_fastugadriver_tests.git/Include/features/us7.feature");
formatter.feature({
  "name": "US7 - Keep Me Logged In",
  "description": "  As a user\n\tI want to keep me login\n\tSo that I don’t have to authenticate myself every time I want to access the application",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check Keep Me Logged In Checkbox Exists",
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
  "name": "the user sees the \"Keep Me Logged In\" checkbox",
  "keyword": "Then "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Opening Application After Logout With Keep Me Signed In",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user opens the application - false",
  "keyword": "Given "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_opens_the_application_false()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Keep Me Logged In\" checkbox",
  "keyword": "And "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_clicks_on_the_checkbox(String)"
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
  "name": "the user clicks on the \"Menu\" in the navbar",
  "keyword": "When "
});
formatter.match({
  "location": "LogoutTests.the_user_clicks_on_the(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Logout\" text in the Menu",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_clicks_on_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user closes the application",
  "keyword": "And "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_closes_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user opens the application - false",
  "keyword": "And "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_opens_the_application_false()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Successful Keep Me Logged In",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user opens the application - false",
  "keyword": "Given "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_opens_the_application_false()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Keep Me Logged In\" checkbox",
  "keyword": "And "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_clicks_on_the_checkbox(String)"
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
  "name": "the user closes the application",
  "keyword": "When "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_closes_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user opens the application - false",
  "keyword": "And "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_opens_the_application_false()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Welcome\" screen",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
});