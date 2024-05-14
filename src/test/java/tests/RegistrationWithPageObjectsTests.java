package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

//заполнение все формы валидными данными
    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName("Anastasiya")
                .setLastName("Murashova")
                .setEmail("qwe@qwe.qwe")
                .setGender("Female")
                .setUserNumber("0123456789")
                .setDateOfBirth(11, "February", "1995")
                .setSubjects("e", "English")
                .setHobbies("Reading")
                .uploadPicture("dog.jpg")
                .setUserAddress("Morozova srt., 12-74")
                .setUserState("N", "NCR")
                .setUserCity("D", "Delhi")
                .submitForm()

                .checkResult("Student Name", "Anastasiya Murashova")
                .checkResult("Student Email", "qwe@qwe.qwe")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "11 February,1995")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "dog.jpg")
                .checkResult("Address", "Morozova srt., 12-74")
                .checkResult("State and City", "NCR Delhi");

    }
    //минимальное количество данных
    @Test
    void fillFormTestMinimal() {

        registrationPage.openPage()
                .setFirstName("Anastasiya")
                .setLastName("Murashova")
                .setGender("Female")
                .setUserNumber("0123456789")
                .submitForm()

                .checkResult("Student Name", "Anastasiya Murashova")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "0123456789");

    }

    //негативная проверка
    @Test
    void fillFormTestNegative() {

        registrationPage.openPage()
                .setFirstName("Anastasiya")
                .setLastName("Murashova")
                .setGender("Female")
                .setUserNumber("0")
                .submitForm()

                .checkEmptyResult();

    }
}