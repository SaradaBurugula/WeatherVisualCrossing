package org.example.models;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyLoader {
    private Properties property = new Properties();

    // Universal property loading
    public String getProperty(String prop) throws NullPointerException {
        if (property.getProperty(prop) == null)
            throw new NullPointerException("Property " + prop + " not found in the property file.");
        return property.getProperty(prop);
    }

    public PropertyLoader() throws IOException {
        String propertyFileNameString = "testdata.properties";
        URL url = ClassLoader.getSystemResource(propertyFileNameString);
        FileReader inputStream = new FileReader(url.getFile());
        property.load(inputStream);
    }

    public Map<String, String> getPropertySubtree(String key) {
        Map<String, String> subtree = new HashMap<String, String>();
        for (String propertyName : property.stringPropertyNames()) {
            if (propertyName.startsWith(key)) {
                subtree.put(propertyName.replace(key + ".", ""), getProperty(propertyName));
            }
        }
        return subtree;
    }

}
