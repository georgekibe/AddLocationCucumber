Feature: Validating Place API's

  Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When User Calls the AddPlace with http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | name   | language  | address            |  |
      | Rakeli | English   | 87 Junction        |  |
      | Atris  | French    | Kipande            |  |
      | Manti  | Kiswahili | Karura Forest Lane |  |




