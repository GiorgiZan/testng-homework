
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization extends NewConfig {

    @Parameters({ "firstName", "lastName", "gender", "mobileNumber" })
    @Test
    public void formDataTest(String firstName, String lastName, String gender, String mobileNumber){
        FillFromAndValidateNameMethod.fillFormAndValidateName(firstName, lastName,gender, mobileNumber);
    }

}


