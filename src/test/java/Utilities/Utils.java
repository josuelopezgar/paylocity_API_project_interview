package Utilities;

import java.util.Random;
import java.util.stream.Collectors;

public class Utils {

    private static String baseUrl = "https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/";
    private static String basePathEmployee = "Prod/api/Employees/";

    public static String getBaseURL() {
        return baseUrl;
    }

    public static String getBasePathEmployee() {
        return basePathEmployee;
    }

    public static String generateRamdomString() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        String randomText = new Random().ints(10, 0, caracteres.length())
                .mapToObj(caracteres::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        return randomText;
    }
}
