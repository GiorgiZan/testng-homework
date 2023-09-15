import org.testng.Assert;
import org.testng.annotations.Test;

public class FailFiveTimes {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void failTestMethod() {
        Assert.fail("Time to fail");
    }
}
