package fizz_buzz_game;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsItFizzBuzzFizzBuzzOrNoneSteps {
    private int number;
    private String answer;

    @Given("number is {int}")
    public void number_is(int number) {
        // Write code here that turns the phrase above into concrete actions
        this.number = number;
    }

    @When("I ask whether it's Fizz, Buzz, FizzBuzz or None")
    public void i_ask_whether_it_s_fizz_buzz_fizzbuzz_or_none() {
        // Write code here that turns the phrase above into concrete actions
        this.answer = FizzBuzzGame.checkForNumber(this.number);
    }
    @Then("the answer should be {string}")
    public void the_answer_should_be(String answer) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(answer, this.answer);
    }
}

