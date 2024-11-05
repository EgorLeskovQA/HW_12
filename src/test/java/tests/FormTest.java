package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RandomFormPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;

@Tag("registrationFormTest")
@DisplayName("Проверка полного заполнения формы")

public class FormTest extends TestBase{

        private final RandomFormPage randomFormPage = new RandomFormPage();
        private final RandomUtils randomData = new RandomUtils();

        String firstName = randomData.firstName(),
                lastName = randomData.lastName(),
                userEmail = randomData.userEmail(),
                gender = randomData.gender(),
                userNumber = randomData.userNumber(),
                dayOfBirth = randomData.dayOfBirth(),
                monthOfBirth = randomData.monthOfBirth(),
                yearOfBirth = randomData.yearOfBirth(),
                subjects = randomData.subjects(),
                hobbies = randomData.hobbies(),
                pictureName = randomData.pictureRandom(),
                address = randomData.address(),
                state = randomData.state(),
                city = randomData.city(state);




        @Test
        void registrationFormTest() {
            step("Открытие страницы регистрации в браузере", () ->
            randomFormPage.openPage());
            randomFormPage.removeBanner();

            step("Заполнение ФИО", () -> {
            randomFormPage.setFirstName(firstName);
            randomFormPage.setLastName(lastName);
            });

            step("Заполнение Email", () ->
            randomFormPage.setEmail(userEmail));

            step("Заполнение пола", () ->
            randomFormPage.setGender(gender));


            step("Заполнение номера телефона", () ->
            randomFormPage.setUserNumber(userNumber));

            step("Заполнение даты рождения", () -> {
            randomFormPage.setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth);
            });

            step("Заполнение предмета", () ->
            randomFormPage.setSubject(subjects));

            step("Заполнение хобби", () ->
            randomFormPage.setHobby(hobbies));

            step("Загрузка картинки", () ->
            randomFormPage.uploadPicture(pictureName));

            step("Заполнение адресса", () ->
            randomFormPage.setCurrentAddress(address));

            step("Заполнение штата и города", () -> {
            randomFormPage.setUserState(state);
            randomFormPage.setUserCity(city);
            randomFormPage.clickSubmit();
            });

            step("Результирующая таблица", () -> {
            randomFormPage.checkSuccessResult("Student Name", firstName + " " + lastName)
                    .checkSuccessResult ("Student Email", userEmail)
                    .checkSuccessResult ("Gender", gender)
                    .checkSuccessResult ("Mobile", userNumber)
                    .checkSuccessResult ("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkSuccessResult ("Subjects", subjects)
                    .checkSuccessResult ("Hobbies", hobbies)
                    .checkSuccessResult ("Picture", pictureName)
                    .checkSuccessResult ("Address", address)
                    .checkSuccessResult ("State and City", state + " " + city);
            });
        }
}
