Feature: Retreiving Weather details of any Place

@PlaceWeather
  Scenario Outline: Retreive weather details for "<Place>" and for any day
    Given User has the "<Place>" place name
    When User calls "GetPlaceAPI" resource url with "GET" http request
    Then API call is success with status code "200"
    And User get the Place ID "woeid"
    Then User get the weather details of "<Place>" for "<Date>"

    Examples: 
      | Place      | Date      |
      | Nottingham | 2021/1/26 |
      | London     | 2021/1/27 |
			|	Oxford		 | 2021/1/28 |