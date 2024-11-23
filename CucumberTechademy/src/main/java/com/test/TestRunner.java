package com.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", // Path to the feature file
		glue = "stepdefinitions", // Package containing step definition classes
		plugin = { "pretty", "html:target/cucumber-reports" } // Report configuration
)
public class TestRunner {
}
