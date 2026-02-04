package com.example.springboottdd.storage;

import com.example.springboottdd.domain.Game;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.example.springboottdd.domain.Result.*;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class RepositoryContract {
    protected Repository repository;

    @Test
    void it_is_empty_initially() {
        var retrievedGames = repository.allGames();

        assertThat(retrievedGames).isEmpty();
    }
    
    @Test
    void games_that_have_been_added_can_be_retrieved() {
        var game1 =
            new Game("Marcus Yip",
                "Nicky Chorley",
                LocalDate.of(2025, 12, 21),
                DRAW,
                """
                    1. d4 d5 2. c4 e6 3. Nf3 Nf6 4. g3 Be7 5. Bg2 O-O 6. cxd5 exd5 7. Nc3 c6
                    8. O-O Nbd7 9. Bf4 Nb6 10. Rc1 Re8 11. Re1 Bd6 12. Bxd6 Qxd6 13. e3 Bg4
                    14. h3 Bxf3 15. Bxf3 Qd7 16. Bg2 Nc4 17. b3 Nd6 18. Qc2 Nfe4 19. Nxe4 Nxe4
                    20. Bxe4 Rxe4 21. Kg2 Qd6 22. Qd3 Qg6 23. Rc3 Rae8 24. f3 R4e6 25. Qxg6 hxg6
                    26. Kf2 R8e7 27. Rc2 Kf8 28. Rce2 f5 29. g4 Ke8 30. gxf5 gxf5 31. Kg3 g5
                    32. f4 gxf4+ 33. Kxf4 Re4+ 34. Kf3 Rh7 35. Rh1 Reh4 36. Kg3 Ke7 37. Rf2 Ke6
                    """
            );
        
        var game2 =
            new Game(
                "Nicky Chorley",
                "John Jestico",
                LocalDate.of(2014, 12, 28),
                BLACK_WON,
                """
                    1.e4 e6 2.d4 d5 3.e5 c5 4.c3 Qb6 5.Nf3 Nc6 6.Na3 a6 7.Nc2 Nge7 8.Be2 Ng6 9.O-O Be7
                    10.Re1 Bd7 11.b3 cxd4 12.cxd4 Rc8 13.Bb2 Na7 14.Rc1 O-O 15.Qd2 Bb5 16.Bxb5 Nxb5
                    17.Qe3 Rc6 18.a4 Na7 19.Na3 Rfc8 20.Rxc6 Rxc6 21.Rc1 Bb4 22.Rxc6 Nxc6 23.Nc2 Na5
                    24.Nxb4 Qxb4 25.Nd2 Nc6 26.Nf3 Nce7 27.Qc3 Nc6 28.Qe3 Nce7 29.Qc3 Qb6 30.Ba3 Nc6
                    31.Bc5 Qa5 32.Qxa5 Nxa5 33.b4 Nc4 34.a5 Nf8 35.Bxf8 Kxf8 36.Kf1 h6 37.Ke2 b6
                    38.axb6 Nxb6 39.Nd2 Ke7
                    40.Nb3 Na8 41.Nc5 Nc7 42.Kd2 Kd8 43.Nb7+ Kd7 44.Na5 Nb5  45.Nb3 Kc6 46.Na5+ Kb6
                    47.Kd3 Na3 48.f4 Kb5 49.Kc3 Ka4 50.Nc6 Nb5+ 51.Kd3 f5 52.Nb8 Nc7
                    53.Nc6 Kb5 54.Na7+ Kxb4
                    """
            );
        
            repository.add(game1);
            repository.add(game2);
            
            var retrievedGames = repository.allGames();
            
            assertThat(retrievedGames).containsExactlyInAnyOrder(game1, game2);
    }
}
