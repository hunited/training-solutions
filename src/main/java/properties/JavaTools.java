package properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

    private final Properties tools;

    public JavaTools() {
        try (
                InputStream resource = DatabaseConfiguration.class.getResourceAsStream("javatools.properties")
        ) {
            tools = load(resource);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file from classpath", ioe);
        }
    }

    private Properties load(InputStream inputStream) {
        Properties result = new Properties();
        try (
                InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)
        ) {
            result.load(reader);
            return result;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read properties file from inputstream", ioe);
        }
    }

    public Set<String> getToolKeys() {
        Set<String> keys;
        Set<String> result = new HashSet<>();
        keys = tools.stringPropertyNames();
        for (String key : keys) {
            if (key.contains("name")) {
                result.add(key.substring(0, key.indexOf('.')));
            }
        }
        return result;
    }

    public Set<String> getTools() {
        Set<String> result = new HashSet<>();
        for (String key : getToolKeys()) {
            result.add(getName(key));
        }
        return result;
    }

    public String getName(String key) {
        return tools.getProperty(key + "." + "name");
    }

    public String getUrl(String key) {
        return tools.getProperty(key + "." + "url");
    }

}
