package Tests;

import Models.EmployeeModel;
import Services.EmployeeService;
import Utilities.BaseTest;
import Utilities.ConfigManager;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Utilities.Utils.generateRamdomString;
import static org.hamcrest.Matchers.equalTo;

public class EmployeeTests extends BaseTest {

    private EmployeeService employeeService;
    private EmployeeModel employeeModel;
    private String generatedEmployeeId;

    @BeforeClass
    public void initTests() {
        employeeService = new EmployeeService();
        employeeModel = new EmployeeModel();
    }

    @Test
    public void testGetEmployeeById() {
        String employeeId = ConfigManager.get("PAYLOCITY_EMPLOYEE_ID");
        Response response = employeeService.getAnEmployeeById(employeeId);

        response.then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(employeeId));
    }

    @Test
    public void createEmployee() {
        String firstName = generateRamdomString();
        employeeModel.setValuesForEmployeeCreation(firstName);

        Response response = employeeService.createEmployee(employeeModel.getCreateEmployeePayload());

        response.then()
                .log().body()
                .statusCode(200)
                .body("firstName", equalTo(firstName))
                .body("dependants", equalTo(2));

        generatedEmployeeId = response.path("id");
    }

    @Test(dependsOnMethods = "createEmployee")
    public void updateEmployeeById() {
        String newName = generateRamdomString();
        employeeModel.setActivityModification(newName);

        Response response = employeeService.updateEmployeeById(employeeModel.getUpdateEmployeePayload());

        response.then()
                .statusCode(200)
                .body("firstName", equalTo(newName))
                .body("dependants", equalTo(4));
    }

    @Test(dependsOnMethods = "createEmployee")
    public void deleteEmployeeById() {
        if (generatedEmployeeId == null) {
            throw new RuntimeException("The end id to delete is null");
        }

        Response response = employeeService.deleteEmployeeById(generatedEmployeeId);
        response.then().statusCode(200);
    }
}