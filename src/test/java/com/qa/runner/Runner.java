package com.qa.runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

/**
 * @author this is the runner class to run the feature and step defination and generate report
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "com.qa.stepdefinations" },
tags = { "@employeeCRUD5TCS" },  plugin = { "pretty", "html:target/cucumber-reports/Cucumber.html" }, monochrome = true)

public class Runner {


}

//for json report- json:target/cucumber-reports/Cucumber.json
//for html report- html:target/cucumber-reports/Cucumber.html