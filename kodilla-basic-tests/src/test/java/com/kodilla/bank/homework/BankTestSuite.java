package com.kodilla.bank.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTestSuite {
    Bank bank = new Bank();

    @Test
    public void shouldHaveZeroLength() {
        assertEquals(0, bank.getNumberOfCashMachines());
    }

    @Test
    public void testAddEmptyCashMachine() {
        bank.addEmptyCashMachine();
        assertEquals(1, bank.getNumberOfCashMachines());
        bank.addEmptyCashMachine();
        bank.addEmptyCashMachine();
        assertEquals(3, bank.getNumberOfCashMachines());
    }

    @Test
    public void testAddDeposit() {
        bank.addEmptyCashMachine();
        bank.addTransaction(0, 320);
        assertEquals(1, bank.getNumberOfDeposits());
        bank.addEmptyCashMachine();
        bank.addEmptyCashMachine();
        bank.addTransaction(0, 215);
        bank.addTransaction(1, -80);
        bank.addTransaction(1, 550);
        bank.addTransaction(2, 550);
        assertEquals(4, bank.getNumberOfDeposits());
    }

    @Test
    public void testAddWithdraw() {
        bank.addEmptyCashMachine();
        bank.addTransaction(0, -320);
        assertEquals(1, bank.getNumberOfWithdraws());
        bank.addEmptyCashMachine();
        bank.addEmptyCashMachine();
        bank.addTransaction(0, -215);
        bank.addTransaction(1, 80);
        bank.addTransaction(1, -550);
        bank.addTransaction(2, -550);
        assertEquals(4, bank.getNumberOfWithdraws());
    }

    @Test
    public void testAddEmptyTransaction() {
        bank.addEmptyCashMachine();
        bank.addTransaction(0, 0);
        assertEquals(0, bank.getNumberOfWithdraws());
        assertEquals(0, bank.getNumberOfDeposits());
    }

    @Test
    public void testAddTransactionToNonexistentCashMachine() {
        bank.addTransaction(0, -320);
        bank.addTransaction(0, 250);
        assertEquals(0, bank.getNumberOfWithdraws());
        assertEquals(0, bank.getNumberOfDeposits());
    }

    @Test
    public void testCalculateBalance() {
        bank.addEmptyCashMachine();
        bank.addEmptyCashMachine();
        bank.addEmptyCashMachine();
        bank.addTransaction(0, 415);
        bank.addTransaction(0, -250);
        bank.addTransaction(1, 305);
        bank.addTransaction(2, -325);
        assertEquals(415 - 250 + 305 - 325, bank.calculateBalance());
    }

    @Test
    public void testCalculateAverageDeposit() {
        bank.addEmptyCashMachine();
        bank.addEmptyCashMachine();
        bank.addEmptyCashMachine();
        bank.addTransaction(0, 150);
        bank.addTransaction(0, 415);
        bank.addTransaction(1, -230);
        bank.addTransaction(1, 230);
        bank.addTransaction(2, 325);
        bank.addTransaction(2, 0);
        assertEquals((150.0 + 415 + 230 + 325) / 4, bank.calculateAverageDeposit(), 0.01);
    }

    @Test
    public void testCalculateAverageWithdraw() {
        bank.addEmptyCashMachine();
        bank.addEmptyCashMachine();
        bank.addEmptyCashMachine();
        bank.addTransaction(0, -150);
        bank.addTransaction(0, -415);
        bank.addTransaction(1, 230);
        bank.addTransaction(1, -230);
        bank.addTransaction(2, -325);
        bank.addTransaction(2, 0);
        assertEquals((150.0 + 415 + 230 + 325) / 4, bank.calculateAverageWithdraw(), 0.01);
    }
}
