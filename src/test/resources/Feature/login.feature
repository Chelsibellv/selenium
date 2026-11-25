Feature: To validate login functionality of the adactin hotel application

  Scenario: Verify that user can login by valid credentials

    When User has to enter the valid username and valid password
    And User has to click the login button
    
  @smoke @sanity
  Scenario Outline:Verify that user can login by invalid credentials
  
  	When User has to enter the Invalid "<username>" and Invalid "<password>"
    And User has to click the login button
    
    Examples:
    	|username|password|
    	|Chelsi|123|
    	|bell|3849|
    	
		
  
    
    
    
    
    