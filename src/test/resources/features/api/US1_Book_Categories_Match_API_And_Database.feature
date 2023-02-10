@api @api_us1
Feature: As a data consumer, I want the book categories in the API to match those in the database

  Background:
    Given the database connection is established

  Scenario: All book categories appearing in database should appear in API
    When GET request sent to "get book categories" endpoint
    And api returns book categories
    Then the api book categories should match those in the database