@CookiesChallenge
Feature: Testing the Login functionality using cookies

  @loginAndStoreCookies
  Scenario Outline: Checking login and storing Cookies
    Given User Opens the home page <URL>
    When User login using valid <username> and <password>
    Then Was directed to the DashBoard page <Elements>
    And Stores the session <Cookies>

    Examples: 
      | URL                                        | username | password | Elements | Cookies            | DashURL                                                                 |
      | https://opensource-demo.orangehrmlive.com/ | Admin    | admin123 |        6 | SessionCookies.txt | https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index |

  @loginThroughCookies
  Scenario Outline: Checking login using stored Cookies
    Given User Opens the home page <URL>
    When User loads the session <Cookies>
    And User opens the <DashURL>
    Then User should be able to see the DashBoard page <Elements>

    Examples: 
      | URL                                        | Elements | Cookies            | DashURL                                                                 |
      | https://opensource-demo.orangehrmlive.com/ |        6 | SessionCookies.txt | https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index |
