package com.example.springboottdd;

import com.example.springboottdd.unit.storage.InMemoryRepository;
import com.example.springboottdd.storage.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ApplicationConfiguration {
    @Bean
    public Repository repository() {
        return new InMemoryRepository();
    }
}
