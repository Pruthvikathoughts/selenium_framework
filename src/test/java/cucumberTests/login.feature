Feature: Login Functionality

  Scenario: User logs in successfully
    Given the user launches the application
    Then Enter the cardiential "Admin" and "admin123"
    And the user clicks the login button
    Then the user should see the dashboard

  Scenario: User not logs in successfully
    Given the user launches the application
    Then Enter the cardiential "Admin" and "admin1234"
    And the user clicks the login button
    Then the user error message "Invalid credentials"
