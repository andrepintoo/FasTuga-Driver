import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType

Mobile.startApplication('C:\\Users\\sfili\\Katalon Studio\\taes22_grupow_fastugadriver_tests.git\\Apk\\app-debug.apk', true)

Mobile.setText(findTestObject('Object Repository/android.widget.EditText - email'), 'contacto@email.pt', 0)

Mobile.setText(findTestObject('Object Repository/android.widget.EditText - password'), 'password', 0)

Mobile.tap(findTestObject('Object Repository/android.widget.Button - LOGIN'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/android.widget.ScrollView - Available Orders List'), 0)

TestObject newObj = new TestObject()
newObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[2]/android.widget.GridLayout[1]/android.widget.Button[1]")

Mobile.tap(newObj, 0)

String orderNumber = Mobile.getAttribute(findTestObject('android.widget.TextView - Order Number'), 'text', 6)
assert orderNumber.compareTo("8438") == 0

String clientName = Mobile.getAttribute(findTestObject('android.widget.TextView - Client Name'), 'text', 6)
assert clientName.compareTo("Customer 2") == 0

String clientPhone = Mobile.getAttribute(findTestObject('android.widget.TextView - Client Phone'), 'text', 6)
assert clientPhone.compareTo("+351 220136359") == 0

String Location = Mobile.getAttribute(findTestObject('android.widget.TextView - Location'), 'text', 6)
assert Location.compareTo("Rua Afonso Lopes Vieira, Leiria") == 0

String Distance = Mobile.getAttribute(findTestObject('android.widget.TextView - Distance'), 'text', 6)
assert Distance.compareTo("2.37 Km") == 0

String Earning = Mobile.getAttribute(findTestObject('android.widget.TextView - Earning'), 'text', 6)
assert Earning.compareTo("2 €") == 0

Mobile.closeApplication()
