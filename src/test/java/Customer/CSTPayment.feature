Feature: Customer Check Transaction after Deposite and withdraw

@CheckTransaction
Scenario Outline: check transaction type of withdraw
  Given Customer Click on CustomerLogin button in HomePage
  And Select "<name>" then press login
  When User make a deposit "<DepositeAmount>"
  And User make	Withdraw "<WithdrawAmount>"
  Then Check the transaction type of the withdraw

  Examples:
      | name| DepositeAmount|WithdrawAmount|
      | Albus Dumbledore|1000|400|
