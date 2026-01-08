package Utilities;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigManager {
    private static Dotenv dotenv;

    static {
        try {
            dotenv = Dotenv.configure()
                    .directory("./")
                    .filename(".env")
                    .ignoreIfMissing()
                    .load();
        } catch (Exception e) {
            System.err.println("Error to load .env: " + e.getMessage());
        }
    }

    public static String get(String key) {
        String value = System.getenv(key);
        if (value == null && dotenv != null) {
            value = dotenv.get(key);
        }
        return value;
    }
}