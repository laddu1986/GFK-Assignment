package com.steps;

import com.hooks.BaseAPISteps;
import com.hooks.BaseSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

/**
 * Created by Laddu shashavali
 */
public class APIServiceSteps extends BaseAPISteps {

    @Given("^I have the service URL for querying all the employees$")
    public void i_have_the_service_url_for_querying_all_the_employees() throws ClientProtocolException, IOException {
        getAutomationPractice().apiservice().buildGetAllQuery();
    }

    @Given("^I have the service URL for adding the employees$")
    public void i_have_the_service_url_for_adding_the_employees() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().buildPostEmployeeQuery();
    }

    @Given("^I have the service URL for querying the employee$")
    public void i_have_the_service_url_for_querying_the_employee() throws ClientProtocolException, IOException {
        getAutomationPractice().apiservice().buildGetEmployeeQuery();
    }

    @Given("^I have the service URL for deleting the employee$")
    public void i_have_the_service_url_for_deleting_the_employee() throws ClientProtocolException, IOException {
        getAutomationPractice().apiservice().buildDeleteEmployeeQuery();
    }

    @When("^I query for the list of employees$")
    public void i_get_the_list_of_employees() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().queryAllEmployees();
    }

    @When("^I add the new employee$")
    public void i_add_the_new_employee() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().responseCreateEmployee();
    }

    @When("^I query the employee created$")
    public void i_query_the_employee_created() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().responseGetCreatedEmployee();
    }

    @When("^I delete the employee created$")
    public void i_delete_the_employee_created() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().responseDeleteEmployee();
    }

    @Then("^I verify the employee schema is as expected$")
    public void i_verify_the_employee_schema_is_as_expected() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().verifyAllEmployees();
    }

    @Then("^I verify the employee is created$")
    public void i_verify_the_employee_is_created() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().verifyCreatedEmployee();
    }

    @Then("^I verify the employee is available$")
    public void i_verify_the_employee_is_available() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().verifyGetCreatedEmployee();
    }

    @Then("^I verify the employee is deleted$")
    public void i_verify_the_employee_is_deleted() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().verifyDeleteEmployee();
    }

    @Given("^I have the service URL for updating the employee$")
    public void i_have_the_service_url_for_updating_the_employee() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().buildUpdateEmployeeQuery();
    }

    @When("^I update new employee$")
    public void i_update_new_employee() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().responseUpdateEmployee();
    }

    @Then("^I verify the employee is updated$")
    public void i_verify_the_employee_is_updated() throws ClientProtocolException, IOException{
        getAutomationPractice().apiservice().verifyUpdateEmployee();
    }

}
