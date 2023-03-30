package us17
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class TurnOnOffNotificationsTests {

	String notificationText = ""

	@Given("the user closes the notifications")
	public void the_user_closes_notifications() {
		Mobile.closeNotifications()
	}

	@Given("the user has the notifications turned off")
	public void the_user_has_notifications_off() {
		Mobile.tap(findTestObject('Object Repository/android.widget.ImageView - Menu'), 0)
		Mobile.tap(findTestObject('Object Repository/android.widget.CheckedTextView - Turn OnOff Notifications'), 0)
		Mobile.tap(findTestObject('Object Repository/android.widget.Switch - Notifications'), 0)
		Mobile.tap(findTestObject('Object Repository/android.widget.ImageButton - Go Back To Application From Settings'), 0)
		Mobile.tapAtPosition(983, 386)
	}

	@Given("the user sees a {string} notification text")
	public void the_user_verifies_notification(String string) {
		TestObject notification = new TestObject()
		notification.addProperty("xpath", ConditionType.EQUALS, "//android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")

		this.notificationText = Mobile.getAttribute(notification, 'text', 0)
		String [] valuesSplit = this.notificationText.split(' ')
		String status = valuesSplit[0]
		assert status.compareTo(string) == 0
	}

	@Then("the user sees the {string} in the Menu")
	public void the_user_sees_the_text(String string) {
		Mobile.verifyElementExist(findTestObject('Object Repository/android.widget.CheckedTextView - '+ string), 0)
	}

	@When("the user switches notifications status")
	public void the_user_switches_notifications() {
		Mobile.tap(findTestObject('Object Repository/android.widget.Switch - Notifications'), 0)
	}

	@When("the user clicks on the {string} image button")
	public void the_user_goes_back(String string) {
		Mobile.tap(findTestObject('Object Repository/android.widget.ImageButton - ' + string), 0)
	}

	@When("the user closes the menu")
	public void the_user_closes_menu() {
		Mobile.tapAtPosition(983, 386)
	}

	@Then("the user sees that the {string} notification doesnt exist")
	public void the_user_doenst_see_notification(String string) {
		TestObject notification = new TestObject()
		notification.addProperty("xpath", ConditionType.EQUALS, "//android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")

		this.notificationText = Mobile.getAttribute(notification, 'text', 0)
		String [] valuesSplit = this.notificationText.split(' ')
		String status = valuesSplit[0]
		assert status.compareTo(string) != 0
	}
}