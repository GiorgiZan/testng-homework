
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderTest extends NewConfig {

    @DataProvider(name = "formData")
    public Object[][] provideDataForm() {
        return new Object[][]{
                {"Giorgi", "Zandarashvili", "male", "5518252221"},
                {"mari", "maridze", "female", "5554443332"},
                {"turtle", "ku", "other", "0123456789"}

        };
    }

    @Test(dataProvider = "formData")
    public void formDataTest(String firstName, String lastName, String gender, String mobileNumber){
        FillFromAndValidateNameMethod.fillFormAndValidateName(firstName, lastName, gender, mobileNumber);
    }

}
