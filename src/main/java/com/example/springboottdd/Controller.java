package com.example.springboottdd;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class Controller {
    private final ArrayList<Game> games = new ArrayList<>();

    @GetMapping("/")
    public List<Game> root() {
        return games;
    }

    @PostMapping("/")
    @ResponseStatus(CREATED)
    public void addGame(@RequestBody Game newGame) {
        games.add(newGame);
    }
}
