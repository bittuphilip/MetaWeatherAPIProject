package ReportUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class TestConfiguration {

    private static String baseURL;
    private static String host;

    private TestConfiguration() {
    }

    private static Properties readProperties(Path file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file.toFile())) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        }
    }

    public static void readRunProperties(Path localFile) throws IOException {
        // check if scope and env properties putted via maven
        if (System.getProperty("baseURL") == null) {
            //if not: read file
            Properties properties = readProperties(localFile);
            baseURL = properties.getProperty("baseURL");
        } else {
            //if yes: read from system
        	baseURL = System.getProperty("baseURL");
        }
    }

    public static void readConfig(Path path) throws IOException {
        Properties properties = readProperties(path);
        host = properties.getProperty("baseURL");
    }


    public static String getHost() {
        return host;
    }

    public static String getEnv() {
        return baseURL;
    }
}