package Tests;

import Models.EmployeeModel;
import Services.EmployeeService;
import Utilities.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static Utilities.Utils.generateRamdomString;
import static org.hamcrest.Matchers.equalTo;

public class EmployeeTests extends BaseTest {
    EmployeeService employeeService = new EmployeeService();
    EmployeeModel employeeModel = new EmployeeModel();
    String generatedEmployeeId;


    @Test
    public void testGetEmployeeById() {
        Response response = employeeService.getAnEmployeeById(employeeModel.getEmployeeId());
        response.then().log().all().statusCode(200).body("id", equalTo(employeeModel.getEmployeeId()));
    }

    @Test
    public void updateEmployeeById() {
        String name = generateRamdomString();
        employeeModel.setActivityModification(name);
        Response response = employeeService.updateEmployeeById(employeeModel.getUpdateEmployeePayload());
        response.then().statusCode(200).body("firstName", equalTo(name)).body("dependants", equalTo(4));
    }

    @Test
    public void createEmployee() {
        String firstName = generateRamdomString();
        employeeModel.setValuesForEmployeeCreation(firstName);
        Response response = employeeService.createEmployee(employeeModel.getCreateEmployeePayload());
        response.then().log().body().statusCode(200).body("firstName", equalTo(firstName)).body("dependants", equalTo(2));
        generatedEmployeeId = response.path("id");
    }

    @Test(dependsOnMethods = "createEmployee")
    public void deleteEmployeeById() {
        Response response = employeeService.deleteEmployeeById(generatedEmployeeId);
        response.then().statusCode(200);
    }
}
