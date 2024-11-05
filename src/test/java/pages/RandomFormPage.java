package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RandomFormPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            userSubjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            userStateInput = $("#react-select-3-input"),
            userCityInput = $("#react-select-4-input"),
            submitInput = $("#submit");


    public RandomFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RandomFormPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RandomFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RandomFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RandomFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RandomFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RandomFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RandomFormPage setBirthDay(String day, String month, String year) {
        calendarInput.click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    public RandomFormPage setSubject(String value) {
        userSubjectInput.setValue(value).pressEnter();
        return this;
    }

    public RandomFormPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RandomFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RandomFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RandomFormPage setUserState(String value) {
        userStateInput.setValue(value).pressEnter();
        return this;
    }

    public RandomFormPage setUserCity(String value) {
        userCityInput.setValue(value).pressEnter();
        return this;
    }

    public void clickSubmit () {
        submitInput.click();
    }

    public RandomFormPage checkSuccessResult(String key, String value) {
        new TableComponents().checkSuccessResult(key, value);
        return this;
    }
}
