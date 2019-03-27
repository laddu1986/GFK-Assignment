package com.controller;

import com.Logger;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.APIServiceModel;
import com.utils.extra_utils.ApiTestUtil;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * This class contains test cases for REST API testing
 * @author LADDU SHASHAVALI
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class APIServiceController extends ApiTestUtil {

    /**
     * Declaring static variables
     */
    private  static String CREATED_EMPLOYEE_ID;
    private  static String CREATED_EMPLOYEE_NAME="test_gfk"+generateRandomNumber();
    private  static HttpUriRequest request=null;
    private  static HttpPost requestPost=null;
    private  static HttpPut requestPut=null;
    private  static HttpDelete requestDelete=null;
    private  static CloseableHttpResponse httpResponse=null;
    private int expectedSalary = generateRandomNumber();
    Logger logger=new Logger(APIServiceController.class);
    /**
     * Methods to test the scenario:
     * "Get all employees and validate the schema returned in the response"
     *
     * @throws ClientProtocolException
     * @throws IOException
     */
    public void buildGetAllQuery() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        request = new HttpGet(APIServiceModel.GET_ALL_EMPLOYEES);
    }

    public void queryAllEmployees() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        httpResponse = HttpClientBuilder.create().build().execute(request);
    }

    public void verifyAllEmployees() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        JsonNode jsonNode = new ObjectMapper().readTree(httpResponse.getEntity().getContent());
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance();
        JsonSchema schema = schemaFactory.getSchema(getClass().getResourceAsStream("/templates/event-schema.json"));
        // Validate the JSON against the schema.
        Set<ValidationMessage> validationErrors = schema.validate(jsonNode);
        assertTrue(validationErrors.size()==0);
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
    }
    /**
     * Methods to test the scenario:
     * "Post a new employee and validate the response"
     *
     * @throws ClientProtocolException
     * @throws IOException
     */
    public void buildPostEmployeeQuery() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        requestPost= new HttpPost(APIServiceModel.CREATE_URL);
        StringEntity body = new StringEntity("{\"name\":\"" + CREATED_EMPLOYEE_NAME +"\",\"salary\":\"123\",\"age\":\"23\"}");
        requestPost.setEntity(body);
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
    }

    public void responseCreateEmployee() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        httpResponse = HttpClientBuilder.create().build().execute(requestPost);
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
    }

    public void verifyCreatedEmployee() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        JsonNode jsonNode = new ObjectMapper().readTree(httpResponse.getEntity().getContent());
        CREATED_EMPLOYEE_ID = jsonNode.get("id").asText();
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        assertNotNull(CREATED_EMPLOYEE_ID);
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
    }
    /**
     * Methods to check the scenario:
     * "Get the newly created employee and validate the response"
     *
     * @throws ClientProtocolException
     * @throws IOException
     */
    public void buildGetEmployeeQuery() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        request = new HttpGet(APIServiceModel.GET_EMPLOYEE+CREATED_EMPLOYEE_ID);
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
    }

    public void responseGetCreatedEmployee() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        httpResponse = HttpClientBuilder.create().build().execute(request);
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
    }

    public void verifyGetCreatedEmployee() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        JsonNode jsonNode = new ObjectMapper().readTree(httpResponse.getEntity().getContent());
        /* Get the newly created employee and validate the response */
        logger.writeLog("INFO","Employeename created: "+CREATED_EMPLOYEE_NAME+" and the response is: "+jsonNode.asText());
        assertEquals(CREATED_EMPLOYEE_NAME, jsonNode.get("employee_name").asText());
        assertEquals("123", jsonNode.get("employee_salary").asText());
        assertEquals("23", jsonNode.get("employee_age").asText());
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
    }

    /**
     * Method to check the scenario:
     * "Update the newly created employee"
     *
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     */

    public void buildUpdateEmployeeQuery() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        requestPut= new HttpPut(APIServiceModel.UPDATE_URL+CREATED_EMPLOYEE_ID);
        StringEntity body = new StringEntity("{\"name\":\"" + CREATED_EMPLOYEE_NAME +"\",\"salary\":\""+expectedSalary+"\",\"age\":\"23\"}");
        requestPut.setEntity(body);
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
    }

    public void responseUpdateEmployee() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        httpResponse = HttpClientBuilder.create().build().execute(requestPut);
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
    }

    public void verifyUpdateEmployee() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
        JsonNode jsonNode = new ObjectMapper().readTree(httpResponse.getEntity().getContent());
        int actualSalary = Integer.parseInt(jsonNode.get("salary").asText());
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        assertEquals(expectedSalary, actualSalary);
        logger.writeLog("INFO","Building a Service URL for running GET_ALL_EMPLOYEES");
    }

    /**
     * Method to check:
     * "Delete the newly created employee"
     * @throws IOException
     * @throws ClientProtocolException
     */

    public void buildDeleteEmployeeQuery() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for DELETE EMPLOYEE using CREATED_EMPLOYEE_ID");
        requestDelete= new HttpDelete(APIServiceModel.DELETE_URL+CREATED_EMPLOYEE_ID);
        logger.writeLog("INFO","Built a Service URL for DELETE EMPLOYEE using CREATED_EMPLOYEE_ID");
    }

    public void responseDeleteEmployee() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for DELETE EMPLOYEE using CREATED_EMPLOYEE_ID");
        httpResponse= HttpClientBuilder.create().build().execute(requestDelete);
        logger.writeLog("INFO","Building a Service URL for DELETE EMPLOYEE using CREATED_EMPLOYEE_ID");
        logger.writeLog("INFO","Building a Service URL for DELETE EMPLOYEE using CREATED_EMPLOYEE_ID");
    }

    public void verifyDeleteEmployee() throws ClientProtocolException, IOException {
        logger.writeLog("INFO","Building a Service URL for DELETE EMPLOYEE using CREATED_EMPLOYEE_ID");
        JsonNode jsonNode = new ObjectMapper().readTree(httpResponse.getEntity().getContent());
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        assertEquals("successfully! deleted Records", jsonNode.get("success").get("text").asText());
        logger.writeLog("INFO","Building a Service URL for DELETE EMPLOYEE using CREATED_EMPLOYEE_ID");
    }

}
