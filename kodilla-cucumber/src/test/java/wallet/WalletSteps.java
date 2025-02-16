package wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class WalletSteps {
    private Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();

    @Given("I have deposited $200 in my wallet")
    public void i_have_deposited_$200_in_my_wallet() {
        // Write code here that turns the phrase above into concrete actions

        wallet.deposit(200);
        Assertions.assertEquals(200, wallet.getBalance(), "Incorrect wallet balance");
    }
    @When("I request $30")
    public void i_request_$30() {
        // Write code here that turns the phrase above into concrete actions
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, 30);
    }
    @Then("$30 should be dispensed")
    public void $30_should_be_dispensed() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(30, cashSlot.getContents());
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
        Cashier cashier = new Cashier(cashSlot);
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
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, -50);
    }
}