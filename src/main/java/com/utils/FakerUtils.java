package com.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {
    private FakerUtils() {
    }

    //if tommorow any thing changes from faker , we just have to change here , one time process.
    private static final Faker faker = new Faker();

    static int getNumber(int startvalue, int endvalue) {
        return faker.number().numberBetween(startvalue, endvalue);
    }

    static String getFirstName() {
        return faker.name().firstName();
    }

    static String getLastName() {
        return faker.name().lastName();
    }

}
