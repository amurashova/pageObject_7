package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTable;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            userAddressInput = $("#currentAddress"),
            stateInput = $("#state input"),
            cityInput = $("#city input"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTable checkResult = new ResultsTable();

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");

        return this;
    }

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));


        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage selectGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month,String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage selectSubjects(String startInput, String hint) {
        subjectsInput.setValue(startInput);
        $(byText(hint)).click();

        return this;
    }

    public RegistrationPage selectHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setUserAddress(String value) {
        userAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage selectUserState(String startInput, String hint) {
        stateInput.setValue(startInput);
        stateCityWrapper.$(byText(hint)).click();

        return this;
    }

    public RegistrationPage selectUserCity(String startInput, String hint) {
        cityInput.setValue(startInput);
        stateCityWrapper.$(byText(hint)).click();

        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();

        return this;
    }

    public  RegistrationPage checkResult(String key, String value)
{
    checkResult.CheckResult(key,value);
    return this;
}

    public RegistrationPage checkEmptyResult() {
        $(".table-responsive")
                .shouldNotBe(appear);

        return this;
    }

}