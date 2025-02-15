package seasonchecker;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("seasonchecker/is_it_summer.feature")
public class TestRunner {

}