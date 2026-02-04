package com.example.springboottdd.storage;

public class InMemoryRepositoryTests extends RepositoryContract {
    public InMemoryRepositoryTests() {
        this.repository = new InMemoryRepository();
    }
}
