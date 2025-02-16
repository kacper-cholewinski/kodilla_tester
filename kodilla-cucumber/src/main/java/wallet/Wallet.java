package wallet;

public class Wallet {

    private int balance = 0;

    public Wallet() {

    }

    public void deposit(int money) {
        this.balance += money;
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }

        return false;
    }

    public int getBalance() {
        return balance;
    }
}
