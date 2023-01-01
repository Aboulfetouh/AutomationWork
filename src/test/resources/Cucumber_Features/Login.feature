@LoginFunctionality
Feature: Testing the Login functionality

  Scenario Outline: Checking login with valid credentials
    Given User opened the Home <URL>
    When User enters "<username>" and "<password>"
    And Clicks on the login button
    Then User is directed to the DashBoard page and its <Elements> are present
    And Takes a screenshot after login

    @positive
    Examples: 
      | URL                                        | username | password | Elements |
      | https://opensource-demo.orangehrmlive.com/ | Admin    | admin123 |        6 |

  Scenario Outline: Checking login with invalid credentials
    Given User opened the Home <URL>
    When User enters "<username>" and "<password>"
    And Clicks on the login button
    Then User gets the validation <Error-Message>

    @negative
    Examples: 
      | URL                                        | username | password | Error-Message       |
      | https://opensource-demo.orangehrmlive.com/ | admin123 | Admin    | Invalid credentials |
      | https://opensource-demo.orangehrmlive.com/ |          |          | Required            |
