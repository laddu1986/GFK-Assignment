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