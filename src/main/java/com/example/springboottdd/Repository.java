package com.example.springboottdd;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {
    private final ArrayList<Game> games = new ArrayList<>();

    public List<Game> allGames() {
        return games;
    }

    public void add(Game newGame) {
        games.add(newGame);
    }
}
