package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefinitions" }, plugin = {
                "pretty",
                "html:target/cucumber-report",
                "json:target/cucumber-report.json",
                "junit:target/cucumber-report.xml"
}, tags = "@addData")

public class TestRunner {

}
