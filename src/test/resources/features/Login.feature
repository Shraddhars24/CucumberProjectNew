Feature: Login related scenarios

  Background:
  #Given user is able to access HRMS application

  @error
  Scenario Outline: Validating the error message for incorrect credentials

    When user enters "<username>" and "<password>" and verify the "<errorMsg>"
    And user clicks on login button





    Examples:
      | username | password | errorMsg |
      |admin     |vnddd     |Invalid credentials|
      |vvnnfnf   |Hum@nhrm123|Invalid credentials|
      |          |Hum@nhrm123|Username cannot be empty|
      |admin     |           |Password is Empty|


  @Reenter

  Scenario:validating the re-enter of username and password after an incorrect attempt

    When user enters "Abra" and "cadabra"

    And user clicks on login button

    And user enters "admin" and "Hum@nhrm123"

    And user clicks on login button

    Then the user is logged in and the dashboard message is displayed