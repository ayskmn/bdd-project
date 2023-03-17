package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/academy/techcenture/features"},
        glue = {"com/academy/techcenture/stepDefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true

        // tags = {"@regression"}
)

public class Runner {

}

