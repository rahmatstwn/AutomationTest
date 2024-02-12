Feature: Test Automation Rest API
  #Write Positive Test Here
  @api
  Scenario: Test Get List Data Normal
    Given prepare url valid for "GET_LIST_USERS"
    And hit api get list user
    Then validation status code is equals to 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test Create New User Normal
    Given prepare url valid for "CREATE_USER"
    And hit api post create new user
    Then validation status code is equals to 201
    Then validation response body create user

  @api
  Scenario: Test Delete User Normal
    Given prepare url valid for "CREATE_USER"
    And hit api post create new user
    Then validation status code is equals to 201
    Then validation response body create user
    And hit api delete user
    Then validation status code is equals to 204

  @api
  Scenario: Test Update User Normal
    Given prepare url valid for "CREATE_USER"
    And hit api post create new user
    Then validation status code is equals to 201
    Then validation response body create user
    And hit api update user
    Then validation status code is equals to 200
    Then validation response body update user

  #Write Negative Test Case Here
  @api #Unprocessable because of email is blank
  Scenario: Test Create New User Blank Email
    Given prepare url valid for "CREATE_USER"
    And hit api post create new user blank email
    Then validation status code is equals to 422

  @api #Unathourize because of Token is not valid
  Scenario: Test Get Specified User with unvalid Token
    Given prepare url valid for "GET_USER_BY_ID"
    And hit api get specified user
    Then validation status code is equals to 401

  #Write Limit Tes Here
  @api #Unprocessable because of max character of name is 200 char
  Scenario: Test Create User with > 200 char of Name
    Given prepare url valid for "CREATE_USER"
    And hit api create user with more than two hundreds char of name
    Then validation status code is equals to 422