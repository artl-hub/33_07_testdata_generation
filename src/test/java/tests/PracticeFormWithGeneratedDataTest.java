package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.RandomUtils;

public class PracticeFormWithGeneratedDataTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    void successfulRegistrationTest() {
        practiceFormPage
                .openPage()
                .removeBanners()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setEmail(randomUtils.userEmail)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.userNumber)
                .setDateOfBirth(randomUtils.birthDay, randomUtils.birthMonth, randomUtils.birthYear)
                .setSubject(randomUtils.subject)
                .setHobbies(randomUtils.hobbies)
                .uploadFile(randomUtils.uploadFile)
                .setAddress(randomUtils.streetAddress)
                .scrollToBottom()
                .stateClick()
                .setState(randomUtils.state)
                .cityClick()
                .setCity(randomUtils.city)
                .submitClick()
                .checkResult("Student Name", randomUtils.firstName)
                .checkResult("Student Email", randomUtils.userEmail)
                .checkResult("Gender", randomUtils.gender)
                .checkResult("Mobile", randomUtils.userNumber)
                .checkResult("Date of Birth", randomUtils.checkDateOfBirth)
                .checkResult("Subjects", randomUtils.subject)
                .checkResult("Hobbies", randomUtils.hobbies)
                .checkResult("Picture", randomUtils.uploadFile)
                .checkResult("Address", randomUtils.streetAddress)
                .checkResult("State and City", randomUtils.state, randomUtils.city)
                .closeModalWindow()
                .modalWindowShouldNotExist();
    }

    @Test
    void successfulRegistrationMinimalDataTest() {
        practiceFormPage
                .openPage()
                .removeBanners()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setEmail(randomUtils.userEmail)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.userNumber)
                .setDateOfBirth(randomUtils.birthDay, randomUtils.birthMonth, randomUtils.birthYear)
                .setAddress(randomUtils.streetAddress)
                .setHobbies(randomUtils.hobbies)
                .scrollToBottom()
                .submitClick()
                .checkResult("Student Name", randomUtils.firstName)
                .checkResult("Student Email", randomUtils.userEmail)
                .checkResult("Gender", randomUtils.gender)
                .checkResult("Mobile", randomUtils.userNumber)
                .checkResult("Date of Birth", randomUtils.checkDateOfBirth)
                .checkResult("Hobbies", randomUtils.hobbies)
                .checkResult("Address", randomUtils.streetAddress)
                .closeModalWindow()
                .modalWindowShouldNotExist();
    }

    @Test
    void shouldNotRegisterWithoutPhoneNumberTest() {
        practiceFormPage
                .openPage()
                .removeBanners()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setEmail(randomUtils.userEmail)
                .setGender(randomUtils.gender)
                .setUserNumber("")
                .setDateOfBirth(randomUtils.birthDay, randomUtils.birthMonth, randomUtils.birthYear)
                .setAddress(randomUtils.streetAddress)
                .setHobbies(randomUtils.hobbies)
                .scrollToBottom()
                .submitClick()
                .modalWindowShouldNotExist();
    }
}

