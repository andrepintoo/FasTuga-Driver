package us19
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



class StatisticsTests {
	int previousBalance = 0
	int previousAssignedOrdersDelivered = 0
	int previousClientsServed = 0
	int previousTotalDeliveryTime = 0
	
	int newBalance = 0
	int newAssignedOrdersDelivered = 0
	int newClientsServed = 0
	int newTotalDeliveryTime = 0
	
	@Then("the user sees the {string} field")
	public void the_user_sees_the_field(String string) {
		Mobile.verifyElementExist(findTestObject('Object Repository/android.widget.TextView - ' + string), 0)
	}

	@When("the user sees the {string} statistics values")
	public void the_user_sees_the_statistics_values(String string) {
		TestObject balanceObj = new TestObject()
		balanceObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]")
		String balance = Mobile.getAttribute(balanceObj, 'text', 0)
		
		TestObject assignedOrdersDeliveredObj = new TestObject()
		assignedOrdersDeliveredObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]")
		String assignedOrdersDelivered = Mobile.getAttribute(assignedOrdersDeliveredObj, 'text', 0)
		
		TestObject clientsServedObj = new TestObject()
		clientsServedObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[2]")
		String clientsServed = Mobile.getAttribute(clientsServedObj, 'text', 0)
		
		TestObject totalDeliveryTimeObj = new TestObject()
		totalDeliveryTimeObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[2]")
		String totalDeliveryTime = Mobile.getAttribute(totalDeliveryTimeObj, 'text', 0)
		
		switch(string) {
			case "previous":
				this.previousBalance = balance.toInteger()
				this.previousAssignedOrdersDelivered = assignedOrdersDelivered.toInteger()
				this.previousClientsServed = clientsServed.toInteger()
				this.previousTotalDeliveryTime = totalDeliveryTime.toInteger()
				break;
			case "new":
				this.newBalance = balance.toInteger()
				this.newAssignedOrdersDelivered = assignedOrdersDelivered.toInteger()
				this.newClientsServed = clientsServed.toInteger()
				this.newTotalDeliveryTime = totalDeliveryTime.toInteger()
				break;
		}
	}

	@Then("the user verifies that the statistics values changed")
	public void the_user_verifies_that_the_statistics_values_changed() {
		assert (this.previousBalance < this.newBalance) &&
				(this.previousAssignedOrdersDelivered < this.newAssignedOrdersDelivered) &&
				(this.previousClientsServed <= this.newClientsServed) &&
				(this.previousTotalDeliveryTime <= this.newTotalDeliveryTime)
	}
}