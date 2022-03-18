package reklama;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {
                "reklama.steps",
                "reklama.hooks"
        },
        tags = "@tests",
        stepNotifications = true
)
public class CucumberRunnerTest {
}
