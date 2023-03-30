$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/sfili/Katalon Studio/taes22_grupow_fastugadriver_tests.git/Include/features/us6.feature");
formatter.feature({
  "name": "US6 - Opt Out",
  "description": "  As a user\n  I want to opt out from the application",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check Opt Out Button Exists",
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
  "name": "the user sees the \"Opt Out\" text in the Menu",
  "keyword": "Then "
});
formatter.match({
  "location": "LogoutTests.the_user_sees_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Successful Opt Out",
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
  "name": "the user fills the \"email login\" field with \"nicole.azevedo@mail.pt\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the \"password login\" field with \"12345678\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"LOGIN\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
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
  "name": "the user clicks on the \"Opt Out\" text in the Menu",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_clicks_on_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the Confirmation Dialog \"Opt Out Confirmation\"",
  "keyword": "And "
});
formatter.match({
  "location": "OptOutTests.the_user_sees_the(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Yes\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
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
  "name": "Check Register with Existing Email After Opt Out",
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
  "name": "the user fills the \"email login\" field with \"nicole.azevedo@mail.pt\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the \"password login\" field with \"12345678\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"LOGIN\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
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
  "name": "the user clicks on the \"Opt Out\" text in the Menu",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_clicks_on_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the Confirmation Dialog \"Opt Out Confirmation\"",
  "keyword": "And "
});
formatter.match({
  "location": "OptOutTests.the_user_sees_the(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Yes\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"REGISTER\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the \"email register2\" field with \"nicole.azevedo@mail.pt\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"REGISTER register2\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the Confirmation Dialog \"Contact Administrator\"",
  "keyword": "Then "
});
formatter.match({
  "location": "OptOutTests.the_user_sees_the(String)"
});
formatter.result({
  "status": "passed"
});
});