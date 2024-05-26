Feature: To Validate positive and negative login scenarios

  Scenario Outline: to validate login flow
    Given I am a user of "<app_name>"
    When I enter "<username>" and "<password>"
    Then I should be able to process the information

    Examples: 
      | app_name | username      | password       |
      | gmail    | abc@gmail.com | djsldsad21     |
      | yahoo    | def@yahoo.com | shddhkasa21321 |
