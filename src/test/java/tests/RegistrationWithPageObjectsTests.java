package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

//заполнение все формы валидными данными
    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Anastasiya")
                .setLastName("Murashova")
                .setEmail("qwe@qwe.qwe")
                .selectGender("Female")
                .setUserNumber("0123456789")
                .setDateOfBirth(11, "February", "1995")
                .selectSubjects("e", "English")
                .selectHobbies("Reading")
                .uploadPicture("dog.jpg")
                .setUserAddress("Morozova srt., 12-74")
                .selectUserState("N", "NCR")
                .selectUserCity("D", "Delhi")
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
                .removeBanner()
                .setFirstName("Anastasiya")
                .setLastName("Murashova")
                .selectGender("Female")
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
                .removeBanner()
                .setFirstName("Anastasiya")
                .setLastName("Murashova")
                .selectGender("Female")
                .setUserNumber("0")
                .submitForm()

                .checkEmptyResult();

    }
}