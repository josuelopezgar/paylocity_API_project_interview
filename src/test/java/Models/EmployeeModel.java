package Models;

import Utilities.ConfigManager;

import java.util.HashMap;
import java.util.Map;

public class EmployeeModel {
    private Map<String, Object> updateEmployeePayload = new HashMap<>();
    private Map<String, Object> createEmployeePayload = new HashMap<>();

    public EmployeeModel() {
    }

    public void setActivityModification(String name) {
        updateEmployeePayload.put("id", ConfigManager.get("PAYLOCITY_EMPLOYEE_EDITION"));
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
