@SmokeTest
Feature: Check Deposit Operation


  Scenario:  Check Login with Valid Parameters
    #Step1 : start driver and navigate to login page
    Given    Start driver and navigate to target url "Chrome"
    #Step2 : select username and click login button
    When     Select userName and click login button
    #Step3 : Validate system login successfully
    Then     Validate system login successfully