package com.example.springboottdd.unit.storage;

public class InMemoryRepositoryTests extends RepositoryContract {
    public InMemoryRepositoryTests() {
        this.repository = new InMemoryRepository();
    }
}
