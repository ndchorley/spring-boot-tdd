package com.example.springboottdd;

import com.example.springboottdd.domain.Game;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryRepository implements Repository {
    private final ArrayList<Game> games = new ArrayList<>();

    @Override
    public List<Game> allGames() {
        return games;
    }

    @Override
    public void add(Game newGame) {
        games.add(newGame);
    }
}
