Feature: BasicTescoPOCTests
  This feature will perform basic POC tests against the Tesco website

  Background: #This is called before every test
    Given User Navigaties to Tesco home page

  Scenario: Navigate to the Tesco Website and assert the homePage title
    Then Check the homePage title is as expected

  Scenario: Navigate tot he Tseco Website and confirm the HTTP responce is 200
    Then Test to return the HTTP responce of the server

  Scenario: Guest users visits Tescos page and clicks on the x Cookie icon
    Then User clicks on close cookie policy button




