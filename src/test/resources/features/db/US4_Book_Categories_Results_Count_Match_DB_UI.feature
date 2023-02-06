
  @db @ui @db_us4

Feature: As a data consumer, I want the UI to display all results for each book category from the database.
Background:


  Scenario Outline:
    Given the user is logged in as "<user>"
    And the database connection is established
    When the user navigates to the "books" page
    And views all book categories
    And selects a book category from the dropdown
    Then the total books in each category should match the database

    Examples:
      | user      |
      | student   |
      | librarian |