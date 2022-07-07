Feature: End-to-end functionality
Given I have the base URL

Scenario: Getting Resource
When User request for a resource by id
Then User get the resource by id

Scenario: ListingAll Resources
When User requests all list of resources
Then User get the list of resources

Scenario Outline: Creating Resource
When User creates resource  with "<id>","<userId>","<title>" and "<body>"
Then The resource is created
Examples:
        |id|userId|title|body|
        |1|4|Jack and John|JACK&JONES is utility streetwear with a strong graphical concept and an eye for innovative details|
        |2|3|Mary Tales|MaryTales which is horror movie|
        |3|2|Rockstar Things|Rockstars are always backbenchers|

Scenario: Updating Resource
When User updates the Resource
|103|123|A Girl with no dreams|A story about Dreams,Hope and Death.|
Then the resource is updated


Scenario: Patching Resource
When User patch a Resource
|1|2|Rockstars|Rockstars are always backbencher|
Then The resource get updated


Scenario: Deleting Resource
When User delete a resource
Then The resource get deleted

Scenario: Filtering Resource
When User want to fetch  details by userId
Then User get details by userId

Scenario: Filtering Resource(NegativeFlow)
When User fetch with wrong userId
Then User details are empty

