
import org.testng.annotations.Test;

public class FactoryTest extends NewConfig {

    private String firstName;
    private String lastName;
    private String gender;
    private String mobileNumber;

    public FactoryTest(String firstName, String lastName, String gender, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
    }


    @Test
    public void formDataTest(){
        FillFromAndValidateNameMethod.fillFormAndValidateName(firstName, lastName, gender, mobileNumber);
    }

}
