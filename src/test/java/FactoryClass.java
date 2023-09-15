import org.testng.annotations.Factory;

public class FactoryClass {
    @Factory
    public static Object[] factoryInstances() {
        return new Object[]{
                new FactoryTest("Giorgi", "Zandarashvili", "male", "5518252221"),
                new FactoryTest("mari", "maridze", "female", "5554443332"),
                new FactoryTest("turtle", "ku", "other", "0123456789")
        };
    }
}