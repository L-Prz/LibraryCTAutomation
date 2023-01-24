@ui @student @ui_us_2
Feature: Student should be able to search for a book by author's name.

  Background:
    Given student is logged into library app

  @search
  Scenario Outline:
    Given the student is on the Book Management page
    When student enters an "<author>" belonging to the library collection in the search bar
    Then the relevant author search results should be displayed

    Examples:
      | author           |
      | J.K. Rowling     |
      | Robert C. Martin |
      | Billy Dering     |

  @search
  Scenario Outline:
    Given the student is on the Book Management page
    When student enters an "<author>" not belonging to the library collection in the search bar
    Then the no author search results should be displayed

    Examples:
      | author          |
      | Stephen King    |
      | Mo Willems      |
      | Joshua Weissman |