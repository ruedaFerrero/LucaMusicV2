Feature: Payment

  Scenario: Accept Payment
    Given I recieve an <payment request>
    And The params are correct
    Then I process and accept the payment
    
  Scenario: Deny Payment
  	Given I receive an <payment request>
  	And The params are not correct
  	Then I process and deny the payment