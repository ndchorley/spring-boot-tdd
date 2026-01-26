package com.example.springboottdd;

import java.time.LocalDate;

public record Game(
    String white,
    String black,
    LocalDate date,
    Result result
) {}
