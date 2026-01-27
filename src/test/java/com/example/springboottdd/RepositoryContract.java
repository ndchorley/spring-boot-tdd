package com.example.springboottdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class RepositoryContract {
    protected Repository repository;

    @Test
    void it_is_empty_initially() {
        var retrievedGames = repository.allGames();

        assertThat(retrievedGames).isEmpty();
    }
}
