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


  @search
  Scenario Outline: As a student, I want to be able to search by author.
    Given the student is on the Book Management page
    When student enters an "<author>" belonging to the library collection in the search bar
    Then the relevant author search results should be displayed

    Examples:
      | author           |
      | J.K. Rowling     |
      | Robert C. Martin |
      | Billy Dering     |

  @search
  Scenario Outline: As a student, I don't want results for authors not in the collection.
    Given the student is on the Book Management page
    When student enters an "<author>" not belonging to the library collection in the search bar
    Then the no author search results should be displayed

    Examples:
      | author          |
      | Stephen King    |
      | Mo Willems      |
      | Joshua Weissman |