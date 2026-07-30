import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// 1. Buka browser
WebUI.openBrowser(GlobalVariable.URL)

// 2. Klik tombol "Make Appointment"
WebUI.click(findTestObject('Page_Homepage/a_Make Appointment'))

// 3. Masukkan username
WebUI.setText(findTestObject('Page_Login/input_Username'), GlobalVariable.username)

// 4. Masukkan password
WebUI.setText(findTestObject('Page_Login/input_Password'), GlobalVariable.password)

// 5. Klik tombol Login
WebUI.click(findTestObject('Page_Login/button_Login'))

// 6. Verifikasi login berhasil
WebUI.verifyElementVisible(findTestObject('Page_Appointment/h2_Make Appointment'))

// 7. TIDAK ADA closeBrowser() DI SINI!