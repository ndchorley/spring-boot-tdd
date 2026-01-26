package com.example.springboottdd;

import java.util.ArrayList;
import java.util.List;

class Repository {
    private final ArrayList<Game> games = new ArrayList<>();

    public List<Game> allGames() {
        return games;
    }

    public void add(Game newGame) {
        games.add(newGame);
    }
}
