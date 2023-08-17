package org.ejemplo.proyecto_base.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/base.feature"
        },
        glue = "org.ejemplo.proyecto_base.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class RunnerTags {
}
