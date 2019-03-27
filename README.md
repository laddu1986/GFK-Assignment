This project is based on Automation Practice website.
 The project is built with a Hybrid Framework -- BDD with Page Object Model (MVC design pattern). 
 
 /******** Running parallel tests*****/
 * To run it from the Command Line Interface, the following codes/syntax are used.
  * mvn clean test -Dcucumber.options="--tags @api"                   //Only debug
  * mvn clean test -Dcucumber.options="--tags @api --tags @web"     //AND
  * mvn clean test -Dcucumber.options="--tags @debug,@smoke"            //OR
  
  /// Running the tests parallelly irrespective of features or all features
  * mvn clean test 
  
 // Run the BDD Runner
 Right click on the runner class and click run 
 
 UI Tests :   
 
 ## Sign in
 #### Preconditions
 * Generated customer with all customer data
 #### Test steps
 * Open [Home page](http://automationpractice.com/index.php)
 * Click *Sign in* button
 * Fill *Email address* to create an account
 * Click *Create an account* 
 * Fill all fields with correct data 
 * Click *Register* button
 #### Assertions
 * My account page(?controller=my-account) is opened
 * Proper username is shown in the header
 * Log out action is available
 
 ## Log in
 #### Preconditions
 * Existing customer
 #### Test steps
 * Open [Home page](http://automationpractice.com/index.php)
 * Click *Sign in* button (in the header)
 * Fill *Email address* in _Already registered_ block
 * Fill *Password* in _Already registered_ block
 * Click *Sign in* 
 #### Assertions
 * My account page(?controller=my-account) is opened
 * Proper username is shown in the header
 * Log out action is available
 
 ## Checkout
 #### Preconditions
 * Existing customer
 * Order details
 #### Test steps
 * Log in as existing customer
 * Click *Women* button in the header
 * Click the product with name "Faded Short Sleeve T-shirts"
 * Click *Add to card*
 * Click *Proceed to checkout*
 * Click *Proceed to checkout*
 * Click *Proceed to checkout*
 * Click by *Terms of service* to agree
 * Click *Proceed to checkout*
 * Click by payment method *Pay by bank wire*
 * Click *I confirm my order*
 #### Assertions
 * Order confirmation page(?controller=order-confirmation) is opened
 * The order is complete.
 * Current page is the last step of ordering 


Task 1 - UI Automated test - Selenium WebDriver
Withthis mail you will find an attached initial automated testing project. It willhelp you to save your time in extracting locators.
 
What do you have?
-web application with url http://automationpractice.com/index.php;
-3 test cases, are described in TESTCASES.md 
-3 automated tests.
 
What is expected?
Useyour experience and design a solution for these test cases. You are allowed touse any tool or technology.
 
Tips:
-Logging
-Readable report
-Failure evidences
-generating random values for insignificant test data, for example, for new user
-Configurable for env/browsers/urls
-Support for parallel execution
 -Reading test data from file, for example, the name of dress, size and color inthe checkout test.
   
 
Task 2 – API tests using Java/C#
Giventhe following web-services:
         
GET            http://dummy.restapiexample.com/api/v1/employees
 
POST          http://dummy.restapiexample.com/api/v1/create
Request:{"name":"test_gk_unique","salary":"123","age":"23"}
Response:{"name":"test_gk_1","salary":"123","age":"23","id":"2982"}
 
GET            http://dummy.restapiexample.com/api/v1/employee/2982
 
PUT            http://dummy.restapiexample.com/api/v1/update/2982
 
DELETE      http://dummy.restapiexample.com/api/v1/update/2982
 
 
 
Creating the following automated test scenarios:
-Get all employees and validate the schema returned in the response
-Post a new employee and validate the response
-Get the newly created employee and validate the response
-Update the newly cared employee
-Delete the newly created employee
 
Weare using dummy API from the site: http://dummy.restapiexample.com/
