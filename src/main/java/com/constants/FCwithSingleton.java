package com.constants;

import lombok.Getter;

@Getter
public class FCwithSingleton {  //single instance of a class at a particluar point of time
    //creational design pattern e.g JDBC and not webdriver

    private static FCwithSingleton INSTANCE = null;

    private FCwithSingleton() {
    }

    public static synchronized FCwithSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FCwithSingleton();
        }
        return INSTANCE;
    }

    private final String requestJsonFolderPath = System.getProperty("user.dir") + "/src/test/resources/jsons/";
    private final String responseJsonFolderPath = System.getProperty("user.dir") + "/output/";
}
