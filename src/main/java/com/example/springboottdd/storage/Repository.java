package com.example.springboottdd.storage;

import com.example.springboottdd.domain.Game;

import java.util.List;

public interface Repository {
    void add(Game newGame);

    List<Game> allGames();
}
