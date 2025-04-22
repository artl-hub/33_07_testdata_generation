package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormWithGeneratedDataTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker(new Locale("en-GB"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();

        String streetAddress = faker.address().streetAddress();
        String Male = faker.

        practiceFormPage
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(Male)
                .setUserNumber("3216549877")
                .setDateOfBirth("30", "May", "2000")
                .setSubject("Math")
                .setHobbies("Sports")
                .uploadFile("logo_demo_qa.png")
                .setAddress(streetAddress)
                .scrollToBottom()
                .stateClick()
                .setState("Uttar Pradesh")
                .cityClick()
                .setCity("Agra")
                .submitClick()
                .checkResult("Student Name", "Alex Smith")
                .checkResult("Student Email", "alex@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "3216549877")
                .checkResult("Date of Birth", "30 May,2000")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "logo_demo_qa.png")
                .checkResult("Address", "Unterdenlinden 12")
                .checkResult("State and City", "Uttar Pradesh Agra");
    }

    @Test
    void successfulRegistrationMinimalDataTest() {

        practiceFormPage
                .openPage()
                .removeBanners()
                .setFirstName("Alex")
                .setLastName("Smith")
                .setEmail("alex@gmail.com")
                .setGender("Male")
                .setUserNumber("3216549877")
                .setDateOfBirth("30", "May", "2000")
                .setAddress("Unterdenlinden 12")
                .setHobbies("Sports")
                .scrollToBottom()
                .submitClick()
                .checkResult("Student Name", "Alex Smith")
                .checkResult("Student Email", "alex@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "3216549877")
                .checkResult("Date of Birth", "30 May,2000")
                .checkResult("Hobbies", "Sports")
                .checkResult("Address", "Unterdenlinden 12");
    }

    @Test
    void shouldNotRegisterWithoutPhoneNumberTest() {

        practiceFormPage
                .openPage()
                .removeBanners()
                .setFirstName("Alex")
                .setLastName("Smith")
                .setEmail("alex@gmail.com")
                .setGender("Male")
                .setUserNumber("")
                .setDateOfBirth("30", "May", "2000")
                .setAddress("Unterdenlinden 12")
                .setHobbies("Sports")
                .scrollToBottom()
                .submitClick()
                .modalWindowShouldNotExist();
    }


}

