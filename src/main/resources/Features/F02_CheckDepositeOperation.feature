@SmokeTest
Feature: Check User Login


  Scenario:  Check Login with Valid Parameters
    #Step1 : Create new Deposit of 1000 Dollars
    When     Create New Deposit
    #Step2 : Validate if deposit created correctly
    Then     Deposit Create Successfully