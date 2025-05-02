package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private final SelenideElement firstNameInput = $("#firstName"),
                                  lastNameInput = $("#lastName"),
                                  userEmailInput = $("#userEmail"),
                                  genderRadioButton = $("#genterWrapper"),
                                  mobilePhoneInput = $("#userNumber"),
                                  calendarInput =  $("#dateOfBirthInput"),
                                  subjectsInput =  $("#subjectsInput"),
                                  hobbiesMultiple = $("#hobbiesWrapper"),
                                  pictureUpload =  $("#uploadPicture"),
                                  addressInput = $("#currentAddress"),
                                  stateSelect =  $("#react-select-3-input"),
                                  citySelect = $("#react-select-4-input"),
                                  submitButton =  $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();


    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setMobilePhone(String value) {
        mobilePhoneInput.setValue(value);

        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbiesMultiple.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage uploadPicture(String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setState(String value) {
        stateSelect.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setCity(String value) {
        citySelect.setValue(value).pressEnter();

        return this;
    }

    public void submit(String value) {
        submitButton.click();

    }
}
