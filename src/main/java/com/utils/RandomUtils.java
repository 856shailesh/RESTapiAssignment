package com.utils;

import java.util.Locale;

public final class RandomUtils {

    //business layer : calling faker lib and through obj .
    private RandomUtils(){}

    public static int getId(){
        return FakerUtils.getNumber(100,1000);
    }

    public static String getFirstName(){
        return FakerUtils.getFirstName().toLowerCase();
    }

    public static String getLastName(){
        return FakerUtils.getLastName().toLowerCase();
    }
}
