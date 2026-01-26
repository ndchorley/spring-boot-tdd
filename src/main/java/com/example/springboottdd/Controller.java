package com.example.springboottdd;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class Controller {
    class Repository {
         final ArrayList<Game> games = new ArrayList<>();
    }

    private final Repository repository = new Repository();

    @GetMapping("/")
    public List<Game> listGames() {
        return repository.games;
    }

    @PostMapping("/")
    @ResponseStatus(CREATED)
    public void addGame(@RequestBody Game newGame) {
        repository.games.add(newGame);
    }
}
