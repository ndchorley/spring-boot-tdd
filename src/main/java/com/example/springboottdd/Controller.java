package com.example.springboottdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class Controller {
    private final ArrayList<String> games = new ArrayList<>();

    @GetMapping("/")
    public List<String> root() {
        return games;
    }

    @PostMapping("/")
    @ResponseStatus(CREATED)
    public void addGame() {}
}
