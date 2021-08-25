package com.constants;


import lombok.Getter;

public class FrameworkConstants {

    private static @Getter final String RequestJsonFolderPath = System.getProperty("user.dir")+ "/src/test/resources/jsons/";
    private static @Getter final String ResponseJsonFolderPath = System.getProperty("user.dir")+ "/output/";
    private static @Getter final String propertyFilePath = System.getProperty("user.dir")+ "/src/test/resources/config.properties";
}
