package tests;



import data.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

//заполнение все формы валидными данными
    @Test
    void fillFormTest() {


        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
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
                .selectUserCity("a", testData.city)
                .submitForm()

                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.emailAddress)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", testData.city);

    }
    //минимальное количество данных

    @Test
    void fillFormTestMinimal() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .selectGender(testData.gender)
                .setUserNumber(testData.number)
                .submitForm()

                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number);

    }

    //негативная проверка
    @Test
    void fillFormTestNegative() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .selectGender(testData.gender)
                .setUserNumber("0")
                .submitForm()

                .checkEmptyResult();

    }
}