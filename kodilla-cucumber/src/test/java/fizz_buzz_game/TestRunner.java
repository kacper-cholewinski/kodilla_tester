package fizz_buzz_game;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("fizz_buzz_game/is_it_fizz_buzz_fizzbuzz_or_none.feature")
public class TestRunner {

}
