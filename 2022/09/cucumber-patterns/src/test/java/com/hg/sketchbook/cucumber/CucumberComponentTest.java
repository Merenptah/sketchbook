package com.hg.sketchbook.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
    plugin = { "pretty", "html:target/cucumber"},
    extraGlue = "com.hg.sketchbook.cucumber.commons")
public class CucumberComponentTest {

}
