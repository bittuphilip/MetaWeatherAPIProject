Feature: Validate if PlaceID is returned multiple times for any Place

@PlaceId
  Scenario Outline: Verify the duplicacy of PlaceID for "<Place>"
    Given User has the "<Place>" place name
    When User calls "GetPlaceAPI" resource url with "GET" http request
    Then Verify "WEOID" count is Equal to 1 for the given place 

    Examples: 
      | Place      |
      | Birmingham |
      | Nottingham |
