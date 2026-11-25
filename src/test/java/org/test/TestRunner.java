package org.test;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\chelsi bell\\eclipse-workspace\\Cucumber\\src\\test\\resources\\Feature",
				 glue = "org.stepdefinition",
				 dryRun = false,
				 monochrome = true,
				 tags = {"@smoke","@sanity"})
public class TestRunner {

}
