@ui @student @ui_us_1
Feature: Books Page

  Background:
    Given student is logged into library app

  @search
  Scenario Outline: As a student, I want to search for a book by title.
    Given the student is on the Book Management page
    When student enters a "<book title>" belonging to the library collection in the search bar
    Then the relevant title search results should be displayed
    Examples:
      | book title   |
      | Harry Potter |
      | Smoke Test   |
      | Wooden Spoon |


  Scenario Outline: As a student, I don't want results that are not in the library collection to appear.
    Given the student is on the Book Management page
    When student enters a "<book title>" not belonging to the library collection in the search bar
    Then the results table should be empty
    Examples:
      | book title              |
      | Sherlock Holmes         |
      | The old man and the sea |
      | Wooden Fork             |