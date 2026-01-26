package com.example.springboottdd;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class Controller {
    private final Repository repository = new Repository();

    @GetMapping("/")
    public List<Game> listGames() {
        return repository.allGames();
    }

    @PostMapping("/")
    @ResponseStatus(CREATED)
    public void addGame(@RequestBody Game newGame) {
        repository.add(newGame);
    }
}
