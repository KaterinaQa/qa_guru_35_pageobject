package pages.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubmittingComponent {

    private final String HEADER = "Thanks for submitting the form";
    private final SelenideElement modalContent = $("#example-modal-sizes-title-lg"),
                                  contentForm = $(".table-responsive");

    public SubmittingComponent checkForm() {
        modalContent.shouldHave(text(HEADER));

        return this;
    }

    public SubmittingComponent checkContentForm(String key, String value) {
        contentForm.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
