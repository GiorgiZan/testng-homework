import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Configuration.reportsFolder;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RadioButtonTests extends ConfigTests {
    SoftAssert softAssert = new SoftAssert();
    @BeforeTest
    public void CheckboxTests()  {
        reportsFolder = "src/main/resources/RadioButtonFailedTests";
    }


    @Test(priority = 2, groups = {"FrontEnd"})
    public void testCheckboxYes() {
        open("https://demoqa.com/radio-button");

        SelenideElement yesRadio = $("label[for='yesRadio']");

        //Create a method in to select ‘Yes’ option
        selectOptionMethod(yesRadio);


        softAssert.assertAll();

    }
    @Test(priority = 1, groups = {"BackEnd"})
    public void testCheckboxNo() {
        open("https://demoqa.com/radio-button");

        SelenideElement noRadio = $("input[id='noRadio']");

        //Create a method to check that ‘No’ option is available (failed case)
        checkIfOptionIsAvailable(noRadio);

        softAssert.assertAll();

    }

    private void selectOptionMethod(SelenideElement option) {
        option.click();
        String checkOption = $(".mt-3").getText();
        //Invoke failed testng soft assertion
        softAssert.assertFalse(checkOption.contains("Yes"), "Invoking failed testng soft assertion (სინამდვიელში მაგ წინადადებაში არის Yes რადგან Yes დავაწექი)");



    }

    private void checkIfOptionIsAvailable(SelenideElement option) {
        softAssert.assertTrue(option.isEnabled(), "Invoking failed testng soft assertion (სინამდვიელში არ არის ეგ enabled)");



    }

}
