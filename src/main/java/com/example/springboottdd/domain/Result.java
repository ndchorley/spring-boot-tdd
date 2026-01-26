package com.example.springboottdd.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Result {
    @JsonProperty("1-0") WHITE_WON,
    @JsonProperty("1/2-1/2") DRAW,
    @JsonProperty("0-1") BLACK_WON
}
