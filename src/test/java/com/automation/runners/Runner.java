package com.automation.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-json"},
		features = {"classpath:features"},
		glue={"com.automation.steps"},
		monochrome = true,
		dryRun = false
		)
public class Runner {

}
