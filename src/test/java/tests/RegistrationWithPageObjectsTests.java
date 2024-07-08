package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;
@Tag("registration_form_tests")

public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    @DisplayName("Успешная регистрация с заполнением всех полей")
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть страницу регистрации", () -> {
        registrationPage.openPage()
                .removeBanner();
        });
        step("Заполнить все поля валидными значениями", () -> {
        registrationPage.setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.emailAddress)
                .selectGender(testData.gender)
                .setUserNumber(testData.number)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .selectSubjects("c", testData.subjects)
                .selectHobbies(testData.hobbies)
                .uploadPicture(testData.picture)
                .setUserAddress(testData.streetAddress)
                .selectUserState("n",testData.state)
                .selectUserCity("a", testData.city);
        });
        step("Отправить форму нажатием submit", () -> {
            registrationPage.submitForm();
        });
        step("Проверить соответетсвие результата введеннным значениям", () -> {
        registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.emailAddress)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", testData.city);
        });
    }


    @Test
    @DisplayName("Успешная регистрация с заполнением обязательных полей")
    void fillFormTestMinimalTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть страницу регистрации", () -> {
            registrationPage.openPage()
                    .removeBanner();
        });
        step("Заполнить обязательные поля валидными значениями", () -> {
        registrationPage.setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .selectGender(testData.gender)
                .setUserNumber(testData.number);
        });
        step("Отправить форму нажатием submit", () -> {
            registrationPage.submitForm();
        });
        step("Проверить соответетсвие результата введеннным значениям", () -> {
            registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number);
        });

    }


    @Test
    @DisplayName("Неуспешная регистрация с невалидным значением поля mobile")

    void fillFormTestNegative() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть страницу регистрации", () -> {
            registrationPage.openPage()
                    .removeBanner();
        });
        step("Звполнить обязательные поля валидными значениями", () -> {
        registrationPage.setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .selectGender(testData.gender);
        });
        step("Звполнить поле mobile невалидным значением", () -> {
            registrationPage.setUserNumber("0");
        });
        step("Отправить форму нажатием submit", () -> {
                registrationPage.submitForm();
        });
        step("Проверить, что таблица с результатом не появляется", () -> {
            registrationPage.checkEmptyResult();
        });

    }
}