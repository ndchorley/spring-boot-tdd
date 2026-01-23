package com.example.springboottdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootTddApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    void it_returns_an_empty_list() throws Exception {
        mvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
    }
    
    @Test
    void a_game_can_be_added() throws Exception {
        mvc.perform(
            post("/")
                .contentType("application/json")
                .content("""
                    {
                        "white": "Tigran Petrosian",
                        "black": "Wolfgang Unzicker",
                        "date": "1960-08-04",
                        "result": "1-0",
                        "moves": "1. d4 Nf6 2. Nf3 e6 3. Bg5 d5 4. c4 c6 5. Qc2 Be7 6. e3 O-O 7. Nc3 h6 8. Bf4 Nbd7 9. cxd5 cxd5 10. Bd3 a6 11. O-O b5 12. a4 b4 13. Na2 Ne8 14. Nc1 a5 15. Nb3 Ba6 16. Bxa6 Rxa6 17. Qd3 Ra7 18. Rfc1 Nd6 19. Bxd6 Bxd6 20. Rc6 Nb8 21. Rc2 Nd7 22. Rac1 Nb6 23. Qb5 Nc4 24. Nfd2 Nxd2 25. Rxd2 Qa8 26. Rdc2 Rd8 27. Rc6 g6 28. g3 Kg7 29. Kf1 Kf8 30. h4 h5 31. R1c2 Kg7 32. Ke1 Kg8 33. Kd1 Kh7 34. Kc1 Kg8 35. Kb1 Kh7 36. Qe2 Qb7 37. Rc1 Kg7 38. Qb5 Qa8 39. f4 Kh7 40. Qe2 Qb7 41. g4 hxg4 42. Qxg4 Qe7 43. h5 Qf6 44. Ka2 Kg7 45. hxg6 Qxg6 46. Qh4 Be7 47. Qf2 Kf8 48. Nd2 Rb7 49. Nb3 Ra7 50. Qh2 Bf6 51. Rc8 Rd7 52. Nc5 b3+ 53. Kxb3 Rd6 54. f5 Rb6+ 55. Ka2"
                    }"""))
            .andExpect(status().isCreated());

        mvc.perform(get("/"))
            .andExpect(
                content().json("""
                  [
                    { "white": "Tigran Petrosian", "black":  "Wolfgang Unzicker", "date":  "1960-08-04"}
                  ]
                  """)
            );
    }
}
