package wallet;

public class Cashier {
    private final CashSlot cashSlot;
    private final CashierDisplay cashierDisplay;

    public Cashier(CashSlot cashSlot, CashierDisplay cashierDisplay) {
        this.cashSlot = cashSlot;
        this.cashierDisplay = cashierDisplay;
    }

    public void withdraw(Wallet wallet, int amount) {
        if (wallet.withdraw(amount)) {
            cashSlot.dispense(amount);
        } else {
            cashSlot.dispense(0);
            cashierDisplay.displayNotEnoughMoneyInWallet();
        }
    }

    public void displayBalance(Wallet wallet) {
        cashierDisplay.displayBalance(wallet.getBalance());
    }
}