package com.kodilla.bank.homework;

import java.util.Arrays;

public class CashMachine {
    private int[] transactions;

    public CashMachine() {
        transactions = new int[0];
    }

    public void addTransaction(int amount) {
        if (amount == 0) {
            System.out.println("transaction amount can't be 0");
            return;
        }

        int[] newTransactions = new int[transactions.length + 1];

        System.arraycopy(transactions, 0, newTransactions, 0, transactions.length);
        newTransactions[newTransactions.length - 1] = amount;

        transactions = newTransactions;
    }

//    public void withdrawMoney(int amount) {
//        addTransaction(-amount);
//    }
//
//    public void depositMoney(int amount) {
//        addTransaction(amount);
//    }

    public int calculateBalance() {
        return Arrays.stream(transactions).sum();
    }

    public int getNumberOfTransactions() {
        return transactions.length;
    }

    public int getNumberOfDeposits() {
        int numberOfCreditTransactions = 0;

        for (int transaction : transactions) {
            if (transaction > 0) {
                numberOfCreditTransactions += 1;
            }
        }

        return numberOfCreditTransactions;
    }

    public int getNumberOfWithdraws() {
        int numberOfDebitTransactions = 0;

        for (int transaction : transactions) {
            if (transaction < 0) {
                numberOfDebitTransactions += 1;
            }
        }

        return numberOfDebitTransactions;
    }

    public int calculateSumOfDeposits() {
        int sumOfDeposits = 0;

        for (int transaction : transactions) {
            if (transaction > 0) {
                sumOfDeposits += transaction;
            }
        }

        return sumOfDeposits;
    }

    public int calculateSumOfWithdraws() {
        int sumOfWithdraws = 0;

        for (int transaction : transactions) {
            if (transaction < 0) {
                sumOfWithdraws -= transaction;
            }
        }

        return sumOfWithdraws;
    }

//    public double calculateAverageDeposit() {
//
//        return (double) calculateSumOfDeposits() / (double) getNumberOfDeposits();
//    }
//
//    public double calculateAverageWithdraw() {
//
//
//        return (double) calculateSumOfWithdraws() / (double) getNumberOfWithdraws();
//    }
}
