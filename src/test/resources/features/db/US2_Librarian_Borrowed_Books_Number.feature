@db @librarian @db_us2
Feature: As a Librarian, I want to know the number of borrowed books.

  Background:
    Given the user is logged in as a librarian
    And the database connection is established

  Scenario: Verify the total amount of borrowed books
    When the user accesses the borrowed books number
    Then the borrowed books number should match with the database
