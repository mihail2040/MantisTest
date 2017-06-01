package com.test.Dem.BDDMantis.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Максим on 01.06.2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"json:target/reports/mainReport.json"},
        features = {"src/test/resources/features"},
        glue = {"com.test.Dem.BDDMantis.StepDefs"} )
public class Runner {

}
