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

Mobile.startApplication(GlobalVariable.apk, false)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)


//
response = WS.sendRequest(findTestObject('Twilio API/Get OTP'))

System.out.println(response)

String str = WS.getElementPropertyValue(response, 'messages[0].body')
System.out.println(str)
String[] arrayText = str.split(' ')
String OTP = arrayText[7]
System.out.println(OTP)

//

Mobile.tap(findTestObject('Mobile/txt_username'), 0)

Mobile.setText(findTestObject('Mobile/txt_username'), OTP , 0)

Mobile.hideKeyboard()

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Mobile/txt_password'), 0)

Mobile.setText(findTestObject('Mobile/txt_password'), 'password', 0)

Mobile.hideKeyboard()

WebUI.delay(10)

