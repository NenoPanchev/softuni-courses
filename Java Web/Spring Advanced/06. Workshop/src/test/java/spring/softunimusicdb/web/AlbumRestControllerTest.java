package spring.softunimusicdb.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import spring.softunimusicdb.model.entities.enums.Genre;
import spring.softunimusicdb.repository.AlbumRepository;
import spring.softunimusicdb.repository.ArtistRepository;
import spring.softunimusicdb.repository.LogRepository;
import spring.softunimusicdb.repository.UserRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class AlbumRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private LogRepository logRepository;

    private AlbumTestData testData;

    @BeforeEach
    public void setUp() {
        testData = new AlbumTestData(userRepository, artistRepository, albumRepository, logRepository);
        testData.init();
    }

    @AfterEach
    public void tearDown() {
        testData.cleanUp();
    }

    @Test
    @WithMockUser(value = "pesho", roles = {"USER", "ADMIN"})
    void testFetchAlbums() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/albums/api"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].name").value("JUSTICE FOR ALL"))
                .andExpect(jsonPath("[0].price").value(10.00))
                .andExpect(jsonPath("[0].genre").value(Genre.METAL.name()))
                .andExpect(jsonPath("[1].name").value("MASTER OF PUPPETS"))
                .andExpect(jsonPath("[1].price").value(10.00))
                .andExpect(jsonPath("[1].genre").value(Genre.METAL.name()));
    }
}
