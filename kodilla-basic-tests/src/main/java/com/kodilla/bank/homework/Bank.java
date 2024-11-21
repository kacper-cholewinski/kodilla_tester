package com.kodilla.bank.homework;

import java.util.Arrays;

public class Bank {
    private CashMachine[] cashMachines;

    public Bank() {
        cashMachines = new CashMachine[0];
    }

    public void addEmptyCashMachine() {
        CashMachine[] newCashMachines = new CashMachine[cashMachines.length + 1];
        System.arraycopy(cashMachines, 0, newCashMachines, 0, cashMachines.length);
        newCashMachines[newCashMachines.length - 1] = new CashMachine();
        cashMachines = newCashMachines;
    }

    public int getNumberOfCashMachines() {
        return cashMachines.length;
    }

    public void addTransaction(int cashMachineIndex, int amount) {
        if (cashMachineIndex < 0 || cashMachineIndex >= cashMachines.length) {
            System.out.println("no cash machine with given index");
            return;
        }

        cashMachines[cashMachineIndex].addTransaction(amount);
    }

    public int calculateBalance() {
        return Arrays.stream(cashMachines)
            .mapToInt(cashMachine -> cashMachine.calculateBalance())
            .sum();
    }

    public int getNumberOfDeposits() {
        return Arrays.stream(cashMachines)
            .mapToInt(cashMachine -> cashMachine.getNumberOfDeposits())
            .sum();
    }

    public int getNumberOfWithdraws() {
        return Arrays.stream(cashMachines)
            .mapToInt(cashMachine -> cashMachine.getNumberOfWithdraws())
            .sum();
    }

    public double calculateAverageDeposit() {
        int numberOfDeposits = Arrays.stream(cashMachines)
            .mapToInt(cashMachine -> cashMachine.getNumberOfDeposits())
            .sum();

        if (numberOfDeposits <= 0) {
            return 0;
        }

        int sumOfDeposits = Arrays.stream(cashMachines)
            .mapToInt(cashMachine -> cashMachine.calculateSumOfDeposits())
            .sum();




        return (double) sumOfDeposits / (double) numberOfDeposits;
    }

    public double calculateAverageWithdraw() {
        int numberOfWithdraws = Arrays.stream(cashMachines)
            .mapToInt(cashMachine -> cashMachine.getNumberOfWithdraws())
            .sum();

        if (numberOfWithdraws <= 0) {
            return 0;
        }

        int sumOfWithdraws = Arrays.stream(cashMachines)
            .mapToInt(cashMachine -> cashMachine.calculateSumOfWithdraws())
            .sum();


        return (double) sumOfWithdraws / (double) numberOfWithdraws;
    }

}
