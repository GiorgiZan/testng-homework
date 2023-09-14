import com.codeborne.selenide.*;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class CheckboxTests extends ConfigTests {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void CheckboxTests() {
        reportsFolder = "src/main/resources/CheckboxFailedTests";
    }


    @Test(groups = {"FrontEnd"})
    public void testCheckboxUncheck() {
        open("http://the-internet.herokuapp.com/checkboxes");

        ElementsCollection checkboxCollection = $("#checkboxes").$$(by("type", "checkbox"));

        // Create a method to uncheck a checked checkbox and invoke a failed TestNG soft assertion
        uncheckCheckbox(checkboxCollection);

        softAssert.assertAll();
    }
    @Test(groups = {"BackEnd"})
    public void testCheckboxCheck() {
        open("http://the-internet.herokuapp.com/checkboxes");

        ElementsCollection checkboxCollection = $("#checkboxes").$$(by("type", "checkbox"));

        // Create a method to check an unchecked checkbox and invoke a failed TestNG soft assertion
        checkCheckbox(checkboxCollection);

        softAssert.assertAll();


    }

    private void uncheckCheckbox(ElementsCollection checkboxes) {
        checkboxes.forEach(checkbox ->{
                    if (checkbox.isSelected()) {
                        checkbox.click();
                        softAssert.assertTrue(checkbox.isSelected(), "Invoking failed testng soft assertion (its not selected)");
                    }

        });
    }

    private void checkCheckbox(ElementsCollection checkboxes) {
        checkboxes.forEach(checkbox ->{
                    if (!checkbox.isSelected()) {
                        checkbox.click();
                    }
                    softAssert.assertFalse(checkbox.isSelected(), "Invoking failed testng soft assertion (all checkboxes are selected)");
                });
    }


}


