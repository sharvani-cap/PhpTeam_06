Feature: End-to-End businessflow for PhpTravels
@ParametrizedTest 
Scenario: Successfully Login to PhpTravels
    Given User have the base URL
    When User enters credentails on Loginpage
       |user@phptravels.com|demouser|     
    Then User should be redirected to PhpTravels Home Page
    
Scenario: Successfully Redirected to SearchPage
    When User click on Flights button
    Then User should be redirected to Search Page 
    
Scenario: Successfully Changed Currency 
    When User click on Currency button
    And  User Select INR Currency
    Then The Currency is  Changed Successfully 
@ParametrizedTest    
Scenario: Successfully Search Flight 
    When User click on Flights tab       
    And User enters FlyingFrom,FlyingTo
       |HYD - Hyderabad - Hyderabad|PNQ - Pune - Pune|
    And User click on Search
    Then User should be redirected to flight Page
    
 Scenario: Successfully Apply filters    
    When User select Direct Flight and Indigo Flights   
    Then  the filtered flights should be displayed
    When  User click on Booknow  
    Then User navigates to FlightBooking Page
 
Scenario: Traveller's Details
      When user enters the details
      And User selects the payment method
      And User clicks on ConfirmBooking
      Then User should be redirected to FlightInvoicePage  
          
Scenario: Booking is Successfull 
      When  User click on proceed
      Then Booking is successfull                       

     


    

    

