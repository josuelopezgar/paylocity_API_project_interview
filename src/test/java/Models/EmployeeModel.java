package Models;

import java.util.HashMap;
import java.util.Map;

public class EmployeeModel {
    private String employeeId = "edff67ca-6a3f-4f15-bb3c-ba3ac45fe59e";
    private Map<String, Object> updateEmployeePayload = new HashMap<>();
    private Map<String, Object> createEmployeePayload = new HashMap<>();

    public EmployeeModel() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setActivityModification(String name) {
        updateEmployeePayload.put("id", "71b2aa24-7857-4e34-92fb-edd2dca591cb");
        updateEmployeePayload.put("firstName", name);
        updateEmployeePayload.put("lastName", "don't delete it");
        updateEmployeePayload.put("dependants", 4);
    }

    public Map<String, Object> getUpdateEmployeePayload() {
        return updateEmployeePayload;
    }

    public void setValuesForEmployeeCreation(String firstName) {
        createEmployeePayload.put("firstName", firstName);
        createEmployeePayload.put("lastName", "API automation");
        createEmployeePayload.put("dependants", 2);
    }

    public Map<String, Object> getCreateEmployeePayload() {
        return createEmployeePayload;
    }
}
