package com.example.springboottdd;

public class InMemoryRepositoryTests extends RepositoryContract {
    public InMemoryRepositoryTests() {
        this.repository = new InMemoryRepository();
    }
}
