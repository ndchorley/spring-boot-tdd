package com.example.springboottdd;

import org.junit.jupiter.api.BeforeEach;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.SQLException;

public class PostgresRepositoryTests extends RepositoryContract {
    private static final String host = "localhost";
    private static final int port = 5432;
    private static final String user = "api";
    private static final String password = "api123";

    public PostgresRepositoryTests() {
        this.repository =
            PostgresRepository
                .createFor(host, port, user, password);
    }
    
    @BeforeEach
    void emptyDatabase() {
        var dataSource = new PGSimpleDataSource();
        dataSource.setURL("jdbc:postgresql://" + host + ":" + port + "/" + user);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        
        try (var connection = dataSource.getConnection()) {
            connection.prepareStatement("TRUNCATE TABLE Games").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
