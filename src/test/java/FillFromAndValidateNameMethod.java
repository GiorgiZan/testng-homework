import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FillFromAndValidateNameMethod {

    public static void fillFormAndValidateName(String firstName, String lastName, String gender, String mobileNumber) {
        open("https://demoqa.com/automation-practice-form");
        // Fill First Name
        SelenideElement firstNameField = $("#firstName");
        firstNameField.sendKeys(firstName);

        // Fill Last Name
        SelenideElement lastNameField = $("#lastName");
        lastNameField.sendKeys(lastName);

        // Select the Gender
        if (gender.equalsIgnoreCase("male")) {
            $("label[for='gender-radio-1']").click();
        } else if (gender.equalsIgnoreCase("female")) {
            $("label[for='gender-radio-2']").click();
        } else {
            $("label[for='gender-radio-3']").click();
        }

        // Fill mobile number
        SelenideElement mobileNumberField = $("#userNumber");
        mobileNumberField.sendKeys(mobileNumber);

        // Pressing sumbit button
        executeJavaScript("arguments[0].click();", $("#submit"));

        //  Validate the Student Name value dynamically
        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
    }
}
