package com.example.springboottdd.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Result {
    @JsonProperty("1-0") WHITE_WON("1-0"),
    @JsonProperty("1/2-1/2") DRAW("1/2-1/2"),
    @JsonProperty("0-1") BLACK_WON("0-1");
    
    Result(String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }

    private final String textValue;
}
