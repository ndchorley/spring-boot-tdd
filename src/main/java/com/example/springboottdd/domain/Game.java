package com.example.springboottdd.domain;

import java.time.LocalDate;

public record Game(
    String white,
    String black,
    LocalDate date,
    Result result,
    String moves
) {}
