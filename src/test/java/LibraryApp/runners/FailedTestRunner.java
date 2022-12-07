package LibraryApp.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="@target/rerun.txt",
        glue="src/test/java/LibraryApp/steps"
)
public class FailedTestRunner {
}
