package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.TestData;

public class PracticeFormWithGeneratedDataTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void successfulRegistrationTest() {
        TestData data = new TestData();

        practiceFormPage
                .openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .setDateOfBirth(data.birthDay, data.birthMonth, data.birthYear)
                .setSubject(data.subject)
                .setHobbies(data.hobby)
                .uploadFile(data.uploadFile)
                .setAddress(data.address)
                .scrollToBottom()
                .stateClick()
                .setState(data.state)
                .cityClick()
                .setCity(data.city)
                .submitClick()
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth", data.checkDateOfBirth)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", data.uploadFile)
                .checkResult("Address", data.address)
                .checkResult("State and City", data.state + " " + data.city)
                .closeModalWindow()
                .modalWindowShouldNotExist();
    }

    @Test
    void successfulRegistrationMinimalDataTest() {
        TestData data = new TestData();

        practiceFormPage
                .openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .setDateOfBirth(data.birthDay, data.birthMonth, data.birthYear)
                .setAddress(data.address)
                .setHobbies(data.hobby)
                .scrollToBottom()
                .submitClick()
                .checkResult("Student Name", data.firstName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth", data.birthDay)
                .checkResult("Hobbies", data.birthMonth)
                .checkResult("Address", data.birthYear)
                .closeModalWindow()
                .modalWindowShouldNotExist();
    }

    @Test
    void shouldNotRegisterWithoutPhoneNumberTest() {
        TestData data = new TestData();
        practiceFormPage
                .openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setUserNumber("")
                .setDateOfBirth(data.birthDay, data.birthMonth, data.birthYear)
                .setAddress(data.address)
                .setHobbies(data.hobby)
                .scrollToBottom()
                .submitClick()
                .modalWindowShouldNotExist();
    }
}

