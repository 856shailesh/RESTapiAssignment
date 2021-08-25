package com.utils;

import com.constants.FrameworkConstants;
import com.enums.PropertiesType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {

    private PropertyUtils() {
    }

    //read the content from property file and store it in hashmap
    //read the content only once(not everytime you read the config file) and store it in some java collection

    private static Properties properties = new Properties();
    private static Map<String, String> MAP = new HashMap<>();

    //Generic Exception , someone has to call

    static {  //Before the whole test execution starts
        try (FileInputStream inputStream = new FileInputStream(FrameworkConstants.getPropertyFilePath())) { //Autoclosable try with resources block
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0); // cannot use throws because this is static and its load first in JVM
        }
        properties.entrySet().forEach(e -> MAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
    }

    public static String getValue(PropertiesType key) {
        return MAP.get(key.name().toLowerCase());
    }
}
