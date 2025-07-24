package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Features/T01_AddSkills.feature") // Path to your features folder
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "Steps") // Step definitions package
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports.html") // Plugins for output
public class RunCucumberTest {
}