package us14
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



class OrderFromClosestFurthestMyOrders {
	@Then("the user sees the assigned orders sorted by {string}")
	public void the_user_sees_the_assigned_orders_sorted_by(String sortType) {
		TestObject firstObj = new TestObject()
		firstObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[1]/android.widget.GridLayout[1]/android.widget.Button[1]")
		String values = Mobile.getAttribute(firstObj, 'text', 6)
		String [] valuesSplit = values.split(':')
		String [] aux = valuesSplit[2].split(' ')

		String firstDistance = aux[1]

		TestObject secondObj = new TestObject()
		secondObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[1]/android.widget.GridLayout[1]/android.widget.Button[2]")
		String secondValues = Mobile.getAttribute(secondObj, 'text', 6)
		String [] secondValuesSplit = secondValues.split(':')
		String [] secondAux = secondValuesSplit[2].split(' ')

		String secondDistance = secondAux[1]

		switch(sortType) {
			case "Closest":
				assert Double.parseDouble(firstDistance) < Double.parseDouble(secondDistance)
				break;
			case "Furthest":
				assert Double.parseDouble(firstDistance) > Double.parseDouble(secondDistance)
				break;
		}
	}
}