$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/UCs_5th_Semester/TA_EngenhariaSoftware/Projeto/taes22_grupow_fastugadriver_tests.git/include/features/us13.feature");
formatter.feature({
  "name": "Order from Closest-Furthest Available Orders",
  "description": "\tAs a user\n\tI want to order Available Orders from the closest or the furthest from the restaurant\n\tSo that I can make a more informed decision on which order to take",
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
  "name": "the user sees the \"Welcome\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Available Orders \"Closest\" Button Exists",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user sees the \"Available Orders Closest\" button",
  "keyword": "Then "
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
  "name": "the user sees the \"Welcome\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Available Orders Sorted by Closest",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user clicks on the \"Available Orders Closest\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the available orders sorted by \"Closest\"",
  "keyword": "Then "
});
formatter.match({
  "location": "OrderFromClosestFurthestAvailableOrders.the_user_sees_the_available_orders_sorted_by(String)"
});
formatter.result({
  "error_message": "com.kms.katalon.core.exception.StepFailedException: Object  not found\r\n\tat com.kms.katalon.core.keyword.internal.KeywordMain.stepFailed(KeywordMain.groovy:50)\r\n\tat com.kms.katalon.core.mobile.keyword.internal.MobileKeywordMain.stepFailed(MobileKeywordMain.groovy:40)\r\n\tat com.kms.katalon.core.mobile.keyword.builtin.GetAttributeKeyword$_getAttribute_closure1.doCall(GetAttributeKeyword.groovy:76)\r\n\tat com.kms.katalon.core.mobile.keyword.builtin.GetAttributeKeyword$_getAttribute_closure1.call(GetAttributeKeyword.groovy)\r\n\tat com.kms.katalon.core.mobile.keyword.internal.MobileKeywordMain.runKeyword(MobileKeywordMain.groovy:21)\r\n\tat com.kms.katalon.core.mobile.keyword.builtin.GetAttributeKeyword.getAttribute(GetAttributeKeyword.groovy:82)\r\n\tat com.kms.katalon.core.mobile.keyword.builtin.GetAttributeKeyword.execute(GetAttributeKeyword.groovy:66)\r\n\tat com.kms.katalon.core.keyword.internal.KeywordExecutor.executeKeywordForPlatform(KeywordExecutor.groovy:74)\r\n\tat com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords.getAttribute(MobileBuiltInKeywords.groovy:1656)\r\n\tat com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords$getAttribute$3.call(Unknown Source)\r\n\tat us13.OrderFromClosestFurthestAvailableOrders.the_user_sees_the_available_orders_sorted_by(OrderFromClosestFurthestAvailableOrders.groovy:52)\r\n\tat ✽.the user sees the available orders sorted by \"Closest\"(D:/UCs_5th_Semester/TA_EngenhariaSoftware/Projeto/taes22_grupow_fastugadriver_tests.git/include/features/us13.feature:19)\r\n",
  "status": "failed"
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
  "name": "the user sees the \"Welcome\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Available Orders \"Furthest\" Button Exists",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user sees the \"Available Orders Closest\" button",
  "keyword": "Then "
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
