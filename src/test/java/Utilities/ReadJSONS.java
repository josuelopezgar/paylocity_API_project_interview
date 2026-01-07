package Utilities;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSONS {

    public static String readJsonFile(String fileName, String parameterName) {
        try {
            String fullPath = System.getProperty("user.dir") + "/src/test/java/Data/" + fileName;

            String json = new String(Files.readAllBytes(Paths.get(fullPath)));

            JSONObject obj = new JSONObject(json);

            return obj.getString(parameterName);

        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON value", e);
        }
    }
}
