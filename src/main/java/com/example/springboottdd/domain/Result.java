package com.example.springboottdd.domain;

public enum Result {
    WHITE_WON("1-0"),
    DRAW("1/2-1/2"),
    BLACK_WON("0-1");
    
    public static Result from(String textValue) {
        return switch (textValue) {
            case "1-0" -> WHITE_WON;
            case "1/2-1/2" -> DRAW;
            case "0-1" -> BLACK_WON;

            default ->
                throw new IllegalStateException("Unexpected value: " + textValue);
        };
    }
    
    Result(String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }

    private final String textValue;
}
