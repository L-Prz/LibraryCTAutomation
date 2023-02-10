@api @api_us2 @wip
Feature: as a data consumer, I want a book added by the API to appear in the database.

  Background:
    Given the database connection is established

  Scenario: Book added by /add_book endpoint should appear in database
    When POST request sent to "add book" endpoint
    Then Status code should be 200
    And the new book should exist in the database