package Utilities;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void setUp() {
        String url = ConfigManager.get("PAYLOCITY_URL");

        if (url == null) {
            throw new RuntimeException("CRITICAL: PAYLOCITY_URL is not found .env");
        }

        RestAssured.baseURI = url;
        RestAssured.authentication = RestAssured.preemptive().basic(
                ConfigManager.get("PAYLOCITY_USER"),
                ConfigManager.get("PAYLOCITY_PASSWORD")
        );
    }
}