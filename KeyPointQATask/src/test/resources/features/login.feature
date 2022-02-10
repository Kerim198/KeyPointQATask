@wip  @login
Feature: Login

  Background:
    Given the user is on the login page

  Scenario: Login as a standart user
    When the user enters standart user credentials
    Then the user should be login successfully

  Scenario: Login as a locked out user
    When the user enters locked out user credentials
    Then the user shouldn't be login and verify error message

  Scenario: Login as a problem user
    When the user enters problem user credentials
    Then the user should be login successfully

  Scenario: Login as a performance glitch user
    When the user enters performance glitch user credentials
    Then the user should be login successfully 6 second later

# negative scenario yu yazdım ama stepleri yazamadım. Biraz yoğunluğum vardı, sorry.
  Scenario Outline: Login with invalid credentials
    When the user enters "<username>" and "<password>"
    Then the user shouldn't be login and verify "<message>"
    Examples:
      | username           | password          | message                                                     |
      | standard_user      |                   | Password is required                                        |
      |                    | secret_sauce      | Username is required                                        |
      |                    |                   | Username is required                                        |
      | standard_userWRONG | secret_sauceWRONG | Username and password do not match any user in this service |
      | 1234?!             | abABZy?)          | Username and password do not match any user in this service |
