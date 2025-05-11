package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {


    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            genderWraper = $("#genterWrapper"),
            calendarInput = $("#dateOfBirthInput"),
            userNumberInput = $("#userNumber"),
            subjectInput = $(".subjects-auto-complete__control input"),
            hobbiesWraper = $("#hobbiesWrapper"),
            chooseFileButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelect = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            citySelect = $("#city"),
            submitButton = $("#submit"),
            modalWindow = $(".modal-title.h4"),
            closeModalWindowButton = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();


    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderWraper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }


    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbiesWraper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadFile(String value) {
        chooseFileButton.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        addressInput.setValue(value).pressEnter();
        return this;
    }


    public PracticeFormPage scrollToBottom() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        return this;
    }

    public PracticeFormPage stateClick() {
        stateSelect.click();
        return this;
    }

    public PracticeFormPage setState(String value) {
        stateCityWrapper.$(byText(value)).click();
        return this;
    }


    public PracticeFormPage cityClick() {
        citySelect.click();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage submitClick() {
        submitButton.click();
        return this;
    }


//    public PracticeFormPage checkResult(String key, String value) {
//        checkResultComponent.checkResult(key, value);
//
//        return this;
//    }

    public PracticeFormPage checkResult(String key, String... values) {
        String expectedValue = String.join(" ", values); // объединяет все значения
        checkResultComponent.checkResult(key, expectedValue);
        return this;
    }

    public PracticeFormPage modalWindowShouldNotExist() {
        modalWindow.shouldNot(exist);
        return this;
    }

    public PracticeFormPage closeModalWindow() {
        closeModalWindowButton.click();
        return this;
    }


}
