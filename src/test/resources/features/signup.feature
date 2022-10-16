@wip
Feature: Sign Up Function

  Scenario Outline: Email Address with invalid datas
    Given user is on signup page
    When user clicks on the Corporate radio button
    And user selects a country from country dropdown
    And user enters valid first name into first name placeholder
    And user enters valid last name into last name placeholder
    And user enters invalid "<email address>" to email address field
    And user selects a country code from country code dropdown
    And user enters valid mobile phone number into mobile phone place holder
    And user clicks on Terms of Use and Privacy Policy check box
    And user enters the result inside captcha
    And user clicks on open my free account button
    Then verify that user see proper warning message
    Examples:
      | email address     |
      |                   |
      | hrnoksuzyahoo.com |
      | hrnoksuz@         |
      | @yahoo.com        |
      | abc @ gmail.com   |


  Scenario: Registration with valid credentials
    Given user is on signup page
    When user clicks on the Corporate radio button
    And user selects a country from country dropdown
    And user enters valid first name into first name placeholder
    And user enters valid last name into last name placeholder
    And user enters valid email address into email address placeholder
    And user selects a country code from country code dropdown
    And user enters valid mobile phone number into mobile phone place holder
    And user clicks on Terms of Use and Privacy Policy check box
    And user enters the result inside captcha
    And user clicks on open my free account button
    Then verify that user can register as a Corporate successfully


  Scenario: Unable to register with registered email address
    Given user is on signup page
    When user clicks on the Corporate radio button
    And user selects a country from country dropdown
    And user enters valid first name into first name placeholder
    And user enters valid last name into last name placeholder
    And user enters already registered email address into email address placeholder
    And user selects a country code from country code dropdown
    And user enters valid mobile phone number into mobile phone place holder
    And user clicks on Terms of Use and Privacy Policy check box
    And user enters the result inside captcha
    And user clicks on open my free account button
    Then verify that user see proper warning message



