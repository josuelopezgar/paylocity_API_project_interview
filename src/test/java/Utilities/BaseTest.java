package Utilities;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static Utilities.ReadJSONS.readJsonFile;
import static Utilities.Utils.getBaseURL;


public class BaseTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = getBaseURL();
        RestAssured.authentication = RestAssured.preemptive().basic(readJsonFile("DataTests.json", "user"), readJsonFile("DataTests.json", "password"));
    }

}
