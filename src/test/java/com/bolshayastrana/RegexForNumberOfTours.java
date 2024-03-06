package com.bolshayastrana;

public class RegexForNumberOfTours {

    public static int regexForNumberOfTours(String count) {

        return Integer.parseInt(count.replaceAll("\\D", ""));
    }
}
