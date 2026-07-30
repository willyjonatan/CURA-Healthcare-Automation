import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory

// ========================================
// 1. AMBIL DATA DARI EXCEL
// ========================================
def testData = TestDataFactory.findTestData('Data Files/AppointmentTestData')

// ========================================
// 2. BUKA BROWSER & LOGIN SEKALI
// ========================================
WebUI.openBrowser(GlobalVariable.URL)
WebUI.click(findTestObject('Page_Homepage/a_Make Appointment'))
WebUI.setText(findTestObject('Page_Login/input_Username'), GlobalVariable.username)
WebUI.setText(findTestObject('Page_Login/input_Password'), GlobalVariable.password)
WebUI.click(findTestObject('Page_Login/button_Login'))
WebUI.verifyElementVisible(findTestObject('Page_Appointment/h2_Make Appointment'))

// ========================================
// 3. LOOP UNTUK SETIAP BARIS DATA (TANPA LOGIN ULANG)
// ========================================
for (int row = 1; row <= testData.getRowNumbers(); row++) {
    
    // 3.1. Isi form dengan data dari Excel
    WebUI.selectOptionByValue(findTestObject('Page_Appointment/select_Facility'), 
                              testData.getValue('facility', row), false)
    WebUI.check(findTestObject('Page_Appointment/input_ApplyForHospitalReadmission'))
    
    // Pilih program berdasarkan data dari Excel
    String program = testData.getValue('program', row)
    if (program == 'Medicaid') {
        WebUI.click(findTestObject('Page_Appointment/input_HealthcareProgram_Medicaid'))
    } else if (program == 'Medicare') {
        WebUI.click(findTestObject('Page_Appointment/input_HealthcareProgram_Medicare'))
    }
    
    WebUI.setText(findTestObject('Page_Appointment/input_VisitDate'), 
                  testData.getValue('visitDate', row))
    WebUI.setText(findTestObject('Page_Appointment/textarea_Comment'), 
                  testData.getValue('comment', row))
    
    // 3.2. Book Appointment
    WebUI.click(findTestObject('Page_Appointment/button_BookAppointment'))
    WebUI.verifyElementVisible(findTestObject('Page_Confirmation/p_ConfirmationText'))
    
    // 3.3. Kembali ke halaman "Make Appointment" untuk isi data berikutnya
    WebUI.click(findTestObject('Page_Confirmation/a_GoToHomepage'))
}

// ========================================
// 4. BUKA HISTORY UNTUK VERIFIKASI SEMUA DATA
// ========================================
WebUI.click(findTestObject('Page_History/button_ToggleMenu'))
WebUI.delay(1)
WebUI.click(findTestObject('Page_History/a_History'))
WebUI.delay(2)

// ========================================
// 5. VERIFIKASI DATA DI HISTORY (CUKUP 1 DATA SEBAGAI SAMPEL)
// ========================================
// Verifikasi bahwa data pertama (fasilitas) muncul di History
WebUI.verifyElementText(findTestObject('Page_History/p_Facility'), 
                        testData.getValue('facility', 1))

// ========================================
// 6. TUTUP BROWSER
// ========================================
WebUI.delay(2)
WebUI.closeBrowser()