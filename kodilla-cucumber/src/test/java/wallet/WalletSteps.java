package wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class WalletSteps {
    private Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();
    private CashierDisplay cashierDisplay = new CashierDisplay();
    private Cashier cashier = new Cashier(cashSlot, cashierDisplay);

    @Given("I have deposited $200 in my wallet")
    public void i_have_deposited_$200_in_my_wallet() {
        // Write code here that turns the phrase above into concrete actions

        wallet.deposit(200);
        Assertions.assertEquals(200, wallet.getBalance(), "Incorrect wallet balance");
    }
    @When("I request $30")
    public void i_request_$30() {
        // Write code here that turns the phrase above into concrete actions
        cashier.withdraw(wallet, 30);
    }
    @Then("$30 should be dispensed")
    public void $30_should_be_dispensed() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(30, cashSlot.getContents());
    }

    @Then("the balance of my wallet should be $170")
    public void the_balance_of_my_wallet_should_be_$170() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(170, wallet.getBalance());
    }

    @Given("I have not deposited any money in my wallet")
    public void i_have_not_deposited_any_money_in_my_wallet() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(0, wallet.getBalance(), "Incorrect wallet balance");
    }
    @Then("No money should be dispensed")
    public void no_money_should_be_dispensed() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(0, cashSlot.getContents());
    }
    @Then("Wallet should stay empty")
    public void wallet_should_stay_empty() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(0, wallet.getBalance(), "Incorrect wallet balance");
    }

    @When("I request $0")
    public void i_request_$0() {
        // Write code here that turns the phrase above into concrete actions
        cashier.withdraw(wallet, 0);
    }
    @When("Wallet balance should stay $200")
    public void wallet_balance_should_stay_$200() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(200, wallet.getBalance(), "Incorrect wallet balance");
    }

    @When("I request -$50")
    public void i_request_minus_$50() {
        // Write code here that turns the phrase above into concrete actions
        cashier.withdraw(wallet, -50);
    }

    @Given("there is ${int} in my wallet")
    public void there_is_$_in_my_wallet(Integer initialBalance) {
        // Write code here that turns the phrase above into concrete actions
        wallet.deposit(initialBalance);
        Assertions.assertEquals(initialBalance, wallet.getBalance(), "Incorrect wallet balance");
    }
    @When("I check the balance of my wallet")
    public void i_check_the_balance_of_my_wallet() {
        // Write code here that turns the phrase above into concrete actions
        cashier.displayBalance(wallet);
    }
    @Then("I should see that the balance is ${int}")
    public void i_should_see_that_the_balance_is_$(Integer currentBalance) {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals("current balance is: " + currentBalance, cashierDisplay.getCurrentContent());
    }

    @When("I withdraw ${int}")
    public void i_withdraw_$(Integer withdrawalAmount) {
        // Write code here that turns the phrase above into concrete actions
        cashier.withdraw(wallet, withdrawalAmount);
    }
    @Then("nothing should be dispensed")
    public void nothing_should_be_dispensed() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(0, cashSlot.getContents());
    }
    @Then("I should be told that I don't have enough money in my wallet")
    public void i_should_be_told_that_i_don_t_have_enough_money_in_my_wallet() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals("not enough money in wallet", cashierDisplay.getCurrentContent());
    }
}