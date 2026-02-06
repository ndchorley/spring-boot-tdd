package com.example.springboottdd.storage;

import com.example.springboottdd.domain.Game;
import com.example.springboottdd.domain.Result;
import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.springboottdd.domain.Result.*;

public class PostgresRepository implements Repository {
    @Override
    public void add(Game newGame) {
        try (var connection = dataSource.getConnection()) {
            var statement = 
                connection.
                    prepareStatement("INSERT INTO Games VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, newGame.white());
            statement.setString(2, newGame.black());
            statement.setDate(3, Date.valueOf(newGame.date()));

            statement.setString(4, newGame.result().toString());
            statement.setString(5, newGame.moves());
            
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Game> allGames() {
        try (var connection = dataSource.getConnection()) {
            var queryResults = 
                connection
                    .prepareStatement("SELECT * FROM Games")
                    .executeQuery();
            
            var games = new ArrayList<Game>();
            
            while (queryResults.next()) {
                var white = queryResults.getString("white");
                var black = queryResults.getString("black");
                var date = queryResults.getDate("date").toLocalDate();
                var result = Result.from(queryResults.getString("result"));;
                
                var moves = queryResults.getString("moves");
                
                games.add(new Game(white, black, date, result, moves));
            }
            
            return Collections.unmodifiableList(games);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Repository createFor(String host, int port, String user, String password) {
        var databaseName = user;
        var jdbcUrl = "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;

        Flyway
            .configure()
            .dataSource(jdbcUrl, user, password)
            .load()
            .migrate();
        
        var dataSource = new PGSimpleDataSource();
        dataSource.setURL(jdbcUrl);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        
        return new PostgresRepository(dataSource);
    }
    
    private PostgresRepository(PGSimpleDataSource dataSource) {
        this.dataSource = dataSource;
    }

    private final PGSimpleDataSource dataSource;
}
