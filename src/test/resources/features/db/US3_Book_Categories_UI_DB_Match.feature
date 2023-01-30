@db @db_us3 @wip
Feature: As a data consumer, I want the book categories in the UI to match those in the DB.

  Scenario Outline:
    Given the user is logged in as "<user>"
    And the database connection is established
    When the user navigates to the "books" page
    And views all book categories
    Then the book categories should match those in the database

    Examples:
      | user      |
      | student   |
      | librarian |