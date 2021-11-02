package com.company.calcium_collision;

public enum Sign {
    PLUS("+"),
    DIVIDE("/"),
    MINUS("-"),
    MULTIPLY("*");

    private final String stringValue;

    Sign(String sign){
        this.stringValue = sign;
    }
    public static Sign fromValue(String value) {
        for (final Sign sign : values()) {
            if (sign.stringValue.equals(value)) {
                return sign;
            }
        }
        return null;
    }
    public String getStringValue() {
        return stringValue;
    }
}

