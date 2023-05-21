Feature: A set of scenarios for testing the "forum" module

  Scenario Outline: Successful search in forum
    Given User in Home page
    When user navigate to login page
    And User enters UserName <UserName> and Password <Password>
    And user navigate to course page <CourseName>
    And user navigate to forum page
    And user navigate to search bar and search a query <query>
    Then all the relevant results display
    Examples:
      | UserName | Password     | CourseName | query  |
      | "tal"    | "Tala12397!" | "qa"       | "abcd" |



  Scenario Outline: Successful delete a massage in forum by the teacher
    Given teacher in Home page
    When teacher navigate to login page
    And teacher enters UserName <UserName> and Password <Password>
    And teacher navigate to course page <CourseName>
    And teacher navigate to forum page
    And teacher navigate to search bar and search a query <query>
    And teacher clicks on the delete button
    And teacher confirm the deletion by clicking on confirm
    Then the comment should be deleted from the forum
    Examples:
      | UserName   | Password    | CourseName | query  |
      | "Admin"    | "Roihass1*" | "qa"       | "abcd" |

  Scenario Outline: search by student and delete a massage in forum by the teacher
    Given teacher and user in Home page
    When teacher navigate to login page
    And user navigate to login page
    And teacher enters UserName <AdminUser> and Password <AdminPassword>
    And User enters UserName <UserName> and Password <Password>
    And teacher navigate to course page <CourseName>
    And user navigate to course page <CourseName>
    And teacher navigate to forum page
    And user navigate to forum page
    And teacher navigate to search bar and search a query <query>
    And user navigate to search bar and search a query <query>
    And teacher clicks on the delete button
    And teacher confirm the deletion by clicking on confirm
    Then the comment should be deleted from the forum
    Examples:
      | AdminUser| AdminPassword| CourseName| query  |UserName|Password     |
      | "Admin"  | "Roihass1*"  | "qa"      | "abcd" | "tal"  | "Tala12397!"|

