package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.SubmittingComponent;

public class PracticeFormPageObjectTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    SubmittingComponent submittingComponent = new SubmittingComponent();

    String firstName = "Raccoon",
           lastName = "QA",
           userEmail = "test@test.com",
           gender = "Female",
           mobilePhone = "1234567890",
           dayOfBirth = "10",
           monthOfBirth = "May",
           yearOfBirth = "2000",
           subjects = "Maths",
           hobbies_0 = "Sports",
           hobbies_1 = "Music",
           avatar = "mem_1.jpg",
           address = "Current Address",
           state = "NCR",
           city = "Delhi";


    @Test
    @DisplayName("Проверка успешного заполнения всех полей формы")
    void successfulFillFormTest() {
        practiceFormPage.openPage()
                        .removeBanner();

        practiceFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setMobilePhone(mobilePhone)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjects)
                .setHobbies(hobbies_0)
                .setHobbies(hobbies_1)
                .uploadPicture(avatar)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        submittingComponent
                .checkForm()
                .checkContentForm("Student Name", firstName + " " + lastName)
                .checkContentForm("Student Email", userEmail)
                .checkContentForm("Gender", gender)
                .checkContentForm("Mobile", mobilePhone)
                .checkContentForm("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkContentForm("Subjects", subjects)
                .checkContentForm("Hobbies", hobbies_0 + ", " + hobbies_1)
                .checkContentForm("Picture", avatar)
                .checkContentForm("Address", address)
                .checkContentForm("State and City", state + " " + city);
    }

    @Test
    @DisplayName("Проверка успешного заполнения обязательных полей формы")
    void requiredFillFormTest() {
        practiceFormPage.openPage()
                        .removeBanner();

        practiceFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setMobilePhone(mobilePhone)
                .submit();

        submittingComponent
                .checkForm()
                .checkContentForm("Student Name", firstName + " " + lastName)
                .checkContentForm("Gender", gender)
                .checkContentForm("Mobile", mobilePhone);
    }

    @Test
    @DisplayName("Валидация заполнения обязательных полей")
    void validationFillFormTest() {
        practiceFormPage.openPage()
                        .removeBanner();

        practiceFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMobilePhone(mobilePhone)
                .submit();

        submittingComponent
                .absenceForm();
    }
}
