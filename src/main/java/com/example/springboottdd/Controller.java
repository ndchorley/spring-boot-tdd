package com.example.springboottdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class Controller {
    @GetMapping("/")
    public List<String> root() {
        return List.of();
    }

    @PostMapping("/")
    @ResponseStatus(CREATED)
    public void addGame() {}
}
