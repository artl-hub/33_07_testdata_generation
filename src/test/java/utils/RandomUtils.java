package utils;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RandomUtils {

    Faker faker = new Faker(new Locale("en-GB"));

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            subject = faker.options().option("English", "Maths", "Biology"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            uploadFile = faker.options().option("picture_1.png", "picture_2.png"),
            streetAddress = faker.address().streetAddress();

    // Дата рождения
    Date birthDate = faker.date().birthday(18, 70);
    SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.ENGLISH);
    SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.ENGLISH);

//    public String
//            birthDay = dayFormat.format(birthDate),
//            birthMonth = monthFormat.format(birthDate),
//            birthYear = yearFormat.format(birthDate);

    public String
            birthDay = dayFormat.format(birthDate),
            birthMonth = monthFormat.format(birthDate),
            birthYear = yearFormat.format(birthDate),
            checkDateOfBirth = String.format("%s %s,%s", birthDay, birthMonth, birthYear);


    // Сначала выбираем state
    public String state = getState();

    // Затем выбираем city в зависимости от state
    public String city = getCity(state);

    public String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "";
        };
    }
}
