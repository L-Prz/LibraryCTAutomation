@db
Feature: Verify the User Table in the database is functioning as expectedly.
Background:
  Given the database connection is established
  Scenario: Verify the User Table contains the correct columns.
    When Execute query to get all columns
    Then verify the below columns are listed in the result
      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |