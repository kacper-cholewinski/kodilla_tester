Feature: Cash Withdrawal
  Scenario: Successful withdrawal from a wallet in credit
    Given I have deposited $200 in my wallet
    When I request $30
    Then $30 should be dispensed

  Scenario: Withdrawing from a empty wallet
    Given I have not deposited any money in my wallet
    When I request $30
    Then No money should be dispensed
    And Wallet should stay empty

  Scenario: Withdrawing a value of $0
    Given I have deposited $200 in my wallet
    When I request $0
    Then No money should be dispensed
    And Wallet balance should stay $200

  Scenario: Withdrawing a negative value
    Given I have deposited $200 in my wallet
    When I request -$50
    Then No money should be dispensed
    And Wallet balance should stay $200