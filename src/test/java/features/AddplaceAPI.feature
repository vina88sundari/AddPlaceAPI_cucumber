Feature: Validating Add Place API

@Addplace
Scenario: Verify if Place is being Successfully added using AddPlaceAPI

Given Add Place Payload
When user calls "AddPlaceAPI" with "POST" http request
Then the API call got success message with status code 200
And "status" in the response body is "OK"
And "scope" in the response body is "APP"

@Addplace
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI

Given Add Place Payload "<name>" and "<address>" and  "<language>"
When user calls "AddPlaceAPI" with "POST" http request
Then the API call got success message with status code 200
And "status" in the response body is "OK"
And "scope" in the response body is "APP"
 
 Examples:
     |name |address|language|
     |Frontline house|29, side layout, cohen 09|French-IN|
     |Vina house|823 side layout, Irving,TX|English|
     
@Addplace @GetPlace     
 Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI

Given Add Place Payload "<name>" and "<address>" and  "<language>"
When user calls "AddPlaceAPI" with "POST" http request
Then the API call got success message with status code 200
And "status" in the response body is "OK"
And "scope" in the response body is "APP"
And "<name>" is added in the "GetPlaceAPI" with "GET" http request
 
 Examples:
     |name |address|language|
     |Frontline house|29, side layout, cohen 09|French-IN|
     #|Vina house|823 side layout, Irving,TX|English|
    
@DeletePlace    
Scenario: Verify if Place is being Successfully removed using DeletePlaceAPI

Given Delete Place Payload
When user calls "DeletePlaceAPI" with "POST" http request
Then the API call got success message with status code 200
And "status" in the response body is "OK"
   
  
     
     
     