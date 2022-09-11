Feature: Customer Check Transaction after Deposite and withdraw

@CheckTransaction
Scenario Outline: Make Deposite and Withdraw and track transactions
  Given Customer Click on CustomerLogin button in HomePage
  And Select "<name>" then press login
  When User make a deposit "<DepositeAmount>"
  And User make	Withdraw "<WithdrawAmount>"
  Then balance should be changed to "600"
  And The "<transactionType>" for withdraw is Debit

  Examples:
      | name| DepositeAmount|WithdrawAmount|transactionType|
      | Albus Dumbledore|1000|400           |Debit|
