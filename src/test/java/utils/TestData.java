package utils;

import static utils.RandomUtils.*;

public class TestData {
    public final String firstName = getFirstName();
    public final String lastName = getLastName();
    public final String email = getUserEmail();
    public final String gender = getGender();
    public final String userNumber = getUserNumber();
    public final String subject = getSubject();
    public final String hobby = getHobby();
    public final String uploadFile = getUploadFile();
    public final String address = getAddress();

    public final String birthDay = getBirthDay();
    public final String birthMonth = getBirthMonth();
    public final String birthYear = getBirthYear();
    public final String checkDateOfBirth = String.format("%s %s,%s", birthDay, birthMonth, birthYear);

    public final String state = getState();
    public final String city = getCity(state);
}