package commonLibs.utils;
import java.io.InputStream;
import java.util.Properties;
public class ConfigUtils {
    public static Properties readProperties(String fileName) {
        Properties properties = new Properties();
        try {
            InputStream inputStream =
                    ConfigUtils.class
                            .getClassLoader()
                            .getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new RuntimeException("Config file not found: " + fileName);
            }
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
