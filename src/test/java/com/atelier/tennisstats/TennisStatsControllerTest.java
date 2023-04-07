package com.atelier.tennisstats;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.atelier.tennisstats.controller.PlayerStatsController;
import com.atelier.tennisstats.model.Country;
import com.atelier.tennisstats.model.Data;
import com.atelier.tennisstats.model.Player;
import com.atelier.tennisstats.service.TennisStatsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class TennisStatsControllerTest {

    @Mock
    private TennisStatsService tennisStatsService;

    @InjectMocks
    private PlayerStatsController tennisStatsController;

    private List<Player> players;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        players = new ArrayList<>();
        players.add(new Player(1, "Ahmed", "Chega", "JD", "M", new Country("US", "USA"), "ikhan.jpg", new Data(1, 100, 80, 180, 25, new int[] {6, 6, 6})));
        players.add(new Player(2, "Ali", "Boya", "JA", "F", new Country("FR", "France"), "khinin.jpg", new Data(2, 200, 60, 170, 27, new int[] {7, 7, 7})));
        players.add(new Player(3, "Ibrahim", "Balage", "BS", "M", new Country("MA", "Maroc"), "atgam.jpg", new Data(3, 150, 90, 190, 30, new int[] {8, 8, 8})));
    }

    @Test
    void testGetSortedPlayers() {
        Mockito.when(tennisStatsService.getAllPlayers()).thenReturn(players);

        List<Player> sortedPlayers = tennisStatsController.getSortedPlayers();

        assertEquals(3, sortedPlayers.size());
        assertEquals("Ahmed", sortedPlayers.get(0).getFirstname());
        assertEquals("Ali", sortedPlayers.get(1).getFirstname());
        assertEquals("Ibrahim", sortedPlayers.get(2).getFirstname());
    }

}
