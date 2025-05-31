package com.qa.runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

/**
 * @author this is the runnerclass to run the feature and step defination and generate report
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "com.qa.stepdefinations" },  plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" }, monochrome = true)

public class Runner {


}
