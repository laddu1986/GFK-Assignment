@api
Feature: This feature file contains the API Test Scenarios for GFK Assignment, includes (Querying all Employee,Add new employee,Get Employee,Delete Employee and Update Employee)- API Service URL: "http://dummy.restapiexample.com/api/v1/"

    @allEmployees
    Scenario: Query all the employees and validating the schema of Response
	Given I have the service URL for querying all the employees
	When I query for the list of employees
	Then I verify the employee schema is as expected

	@addEmployee
    Scenario: Add the new employee
    	Given I have the service URL for adding the employees
    	When I add the new employee
    	Then I verify the employee is created
	
	@getEmployee
    Scenario: Query the newly created employee
    	Given I have the service URL for querying the employee
    	When I query the employee created
    	Then I verify the employee is available
	
    @deleteEmployee
    Scenario: Delete the newly created employee
	Given I have the service URL for deleting the employee
	When I delete the employee created
	Then I verify the employee is deleted

    @updateEmployee
    Scenario: Update the newly added employee
    	Given I have the service URL for updating the employee
    	When I update new employee
    	Then I verify the employee is updated