@ui @student
Feature: Books Page

  Background:
    Given student is logged into library app

  @search
  Scenario Outline: As a student, I want to search for a book by title.
    Given the student is on the Book Management page
    When student enters a "<book title>" belonging to the library collection in the search bar
    Then the relevant search results should be displayed
    Examples:
      | book title   |
      | Harry Potter |
      | Smoke Test   |
      | Wooden Spoon |