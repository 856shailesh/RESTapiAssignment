package com.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ApiUtils {

    private ApiUtils() {
    }

    //Reading form a file
    @SneakyThrows
    public static String readJsonAndGetString(String filepath) {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    //Storing output in a file
    @SneakyThrows
    public static void storeStringAsJsonFile(String filepath, Response response) {
        Files.write(Paths.get(filepath), response.asByteArray());
    }
}
