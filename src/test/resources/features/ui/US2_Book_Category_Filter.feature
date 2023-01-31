@ui @ui_us2 @wip
  Feature: As a user, I want to filter Book results by category.

    Scenario Outline: When a book category is selected from the dropdown, the results table should only display relevant results.
      Given the user is logged in as "<user>"
      When the user navigates to the "books" page
      And selects a book category from the dropdown
      Then the results table should display only books from that genre.

      Examples:
        | user      |
        | student   |
        | librarian |