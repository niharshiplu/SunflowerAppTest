package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/features"},
		glue = {"steps"},
		plugin = { "summary", "pretty:target/cucumber-pretty.txt", "html:target/cucumber-html-report/cucumber.html" },
		monochrome = true,
		tags = "(@smoke-01 or @smoke-02 or @func-01 or @func-02)",
		dryRun = false  
		)

public class TestRunner {

	
}
