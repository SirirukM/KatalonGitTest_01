import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

@com.kms.katalon.core.annotation.SetUp
def Setup() {
	WebUI.openBrowser(url)
}

'Click login in regisbtn'
//WebUI.click(findTestObject('Object Repository/Test_vorlunRegis/Page_/a_'))

'Call login functions'
//WebUI.callTestCase(findTestCase('Common Test Cases/Login'), [('EMAIL') : EMIAL, ('PASSWORD') : PASSWORD], FailureHandling.STOP_ON_FAILURE)

'Fill Email'
WebUI.setText(findTestObject('Object Repository/Test_vorlunRegis/Page_ -/input_EMAIL'), EMAIL, FailureHandling.STOP_ON_FAILURE)

'Fill password'
WebUI.setText(findTestObject('Object Repository/Test_vorlunRegis/Page_ -/input_PASSWORD'), PASSWORD, FailureHandling.STOP_ON_FAILURE)

'Fill reconfirm password'
WebUI.setText(findTestObject('Object Repository/Test_vorlunRegis/Page_ -/input_password_confirmation'), password_confirmation, FailureHandling.STOP_ON_FAILURE)

'Click login'
WebUI.click(findTestObject('Object Repository/Test_vorlunRegis/Page_ -/input_submit'))

'Get status expected test case result'
switch(statusExpectedResult.toString())
{
	case 'email_is_empty':
		'Verify when expected test case login with email is empty'
		def errorMess = WebUI.getText(findTestObject('Object Repository/Test_vorlunRegis/Page_ -/input_PASSWORD'))
		WebUI.verifyEqual(errorMess.contains('Password is required'), true)
		break;
	case 'email_isnot_correct':
		'Verify when expected test case login with password is not correct'
		def errorMess = WebUI.getText(findTestObject('Object Repository/Test_vorlunRegis/Page_ -/input_PASSWORD'))
		WebUI.verifyEqual(errorMess.contains('Authentication failed'), true)
		break;
	case 'email_isnot_confirm':
		'Verify when expected test case login with password_confirm is not correct'
		def errorMess = WebUI.getText(findTestObject('Object Repository/Test_vorlunRegis/Page_ -/input_PASSWORD'))
		WebUI.verifyEqual(errorMess.contains('Authentication failed'), true)
		break;
}

@com.kms.katalon.core.annotation.SetUp
def Teardown () {
	WebUI.closeBrowser()
}