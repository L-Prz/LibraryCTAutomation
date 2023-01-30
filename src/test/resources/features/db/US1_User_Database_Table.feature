@db @db_us1
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

  Scenario: Verify each user has a unique ID.
    When Execute query to get total count of user ids
    And execute query to get count of unique user ids
    Then verify the number of total user ids is equal to unique user ids
