package com.kodilla.bank.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashMachineTestSuite {

    CashMachine cashMachine = new CashMachine();

    @Test
    public void shouldHaveZeroLength() {
        assertEquals(0, cashMachine.getNumberOfTransactions());
    }

    @Test
    public void testAddDeposit() {
        cashMachine.addTransaction(150);
        assertEquals(1, cashMachine.getNumberOfTransactions());
        assertEquals(1, cashMachine.getNumberOfDeposits());
        assertEquals(0, cashMachine.getNumberOfWithdraws());
        assertEquals(150, cashMachine.calculateBalance());
        assertEquals(150, cashMachine.calculateSumOfDeposits());
        assertEquals(0, cashMachine.calculateSumOfWithdraws());
    }

    @Test
    public void testAddWithdraw() {
        cashMachine.addTransaction(-235);
        assertEquals(1, cashMachine.getNumberOfTransactions());
        assertEquals(0, cashMachine.getNumberOfDeposits());
        assertEquals(1, cashMachine.getNumberOfWithdraws());
        assertEquals(-235, cashMachine.calculateBalance());
        assertEquals(0, cashMachine.calculateSumOfDeposits());
        assertEquals(235, cashMachine.calculateSumOfWithdraws());
    }

    @Test
    public void testAddEmptyTransaction() {
        cashMachine.addTransaction(0);
        assertEquals(0, cashMachine.getNumberOfTransactions());
        assertEquals(0, cashMachine.getNumberOfDeposits());
        assertEquals(0, cashMachine.getNumberOfWithdraws());
        assertEquals(0, cashMachine.calculateBalance());
        assertEquals(0, cashMachine.calculateSumOfDeposits());
        assertEquals(0, cashMachine.calculateSumOfWithdraws());
    }

    @Test
    public void testAddMultipleTransactions() {
        cashMachine.addTransaction(150);
        cashMachine.addTransaction(-235);
        cashMachine.addTransaction(0);
        assertEquals(2, cashMachine.getNumberOfTransactions());
        assertEquals(1, cashMachine.getNumberOfDeposits());
        assertEquals(1, cashMachine.getNumberOfWithdraws());
        assertEquals(-85, cashMachine.calculateBalance());
        assertEquals(150, cashMachine.calculateSumOfDeposits());
        assertEquals(235, cashMachine.calculateSumOfWithdraws());
    }
}