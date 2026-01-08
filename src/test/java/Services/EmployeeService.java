package Services;

import io.restassured.response.Response;

import java.util.Map;

import static Utilities.Utils.getBasePathEmployee;
import static io.restassured.RestAssured.given;

public class EmployeeService {

    public Response getAnEmployeeById(String employee) {
        Response response = given().when().log().uri().get(getBasePathEmployee() + employee);
        return response;
    }

    public Response updateEmployeeById( Map<String, Object> payload) {
        Response response = given().when().log().uri()
                .contentType("application/json")
                .body(payload)
                .put(getBasePathEmployee());
        return response;
    }

    public Response createEmployee(Map<String, Object> payload) {
        Response response = given().when().log().uri()
                .contentType("application/json")
                .body(payload)
                .post(getBasePathEmployee());
        return response;
    }

    public Response deleteEmployeeById(String employeeId) {
        Response response = given().when().log().uri()
                .delete(getBasePathEmployee() + employeeId);
        return response;
    }
}
