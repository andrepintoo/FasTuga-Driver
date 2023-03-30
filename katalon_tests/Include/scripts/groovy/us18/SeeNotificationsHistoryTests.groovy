package us18

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import internal.GlobalVariable
import cucumber.api.java.en.Then

public class SeeNotificationsHistoryTests {
	
	String previousNotification = "";
	
	@Then("the user sees the Orders Ready Notification list")
	public void the_user_sees_the_list_ready() {
		TestObject newObj = new TestObject()
		newObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[1]/android.widget.GridLayout[1]")
		Mobile.verifyElementExist(newObj, 0)
	}


	@Then("the user sees the {string} button in the Orders Ready Notification list")
	public void the_user_clicks_the_button_in_the_list_ready(String string) {
		TestObject obj = new TestObject(string)
		obj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[1]/android.widget.GridLayout[1]/android.widget.Button[1]")
		Mobile.verifyElementExist(obj, 0)
	}
	
	@Then("the user sees the {string} button in the Orders Ready Notification list still exists")
	public void the_user_clicks_the_button_in_the_list_ready_still_exists(String string) {
		TestObject obj = new TestObject(string)
		obj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[1]/android.widget.GridLayout[1]/android.widget.Button[2]")
		String value = Mobile.getAttribute(obj, 'text', 6)
	    assert value.compareTo(this.previousNotification) == 0
	}

	@Then("the user sees the Orders Cancelled Notification list")
	public void the_user_sees_the_list_cancelled() {
		TestObject newObj = new TestObject()
		newObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[2]/android.widget.GridLayout[1]")
		Mobile.verifyElementExist(newObj, 0)
	}


	@Then("the user sees the {string} button in the Orders Cancelled Notification list")
	public void the_user_clicks_the_button_in_the_list_cancelled(String string) {
		TestObject obj = new TestObject(string)
		obj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[2]/android.widget.GridLayout[1]/android.widget.Button[1]")
		Mobile.verifyElementExist(obj, 0)
	}
	
	@When("the user sees the text button in the Orders Ready Notification list")
	public void the_user_sees_text() {
		Mobile.delay(3)
		TestObject obj = new TestObject()
		obj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[1]/android.widget.GridLayout[1]/android.widget.Button[1]")
		String value = Mobile.getAttribute(obj, 'text', 6)
		this.previousNotification = value
	}
}
