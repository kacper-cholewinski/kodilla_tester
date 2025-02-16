package wallet;

public class CashierDisplay {
    private String displayedContent = "";

    public void displayBalance(int balance) {
        displayedContent = "current balance is: " + balance;
    }

    public void displayNotEnoughMoneyInWallet() {
        displayedContent = "not enough money in wallet";
    }

    public String getCurrentContent() {
        return displayedContent;
    }
}
