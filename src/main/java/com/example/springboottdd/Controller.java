package com.example.springboottdd;

import com.example.springboottdd.domain.Game;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

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
