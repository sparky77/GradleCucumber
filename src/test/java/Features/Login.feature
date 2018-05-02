Feature: LoginFeature
  This Login feature will login to the application under test

  Scenario: Guest users visits Tescos page and clicks on the x Cookie icon 
    Given User Navigaties to Tesco page
    And Test to return the HTTP responce of the server OH YEAH
    And User enters correct password details
    When User clicks the login button
    Then User is succesfully logged in




