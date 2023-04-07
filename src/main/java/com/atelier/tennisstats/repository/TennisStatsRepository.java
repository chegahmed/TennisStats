package com.atelier.tennisstats.repository;

import com.atelier.tennisstats.model.Player;

import java.util.List;

public interface TennisStatsRepository {
    List<Player> getAllPlayer();

    Player getPlayerById(int id);

    List<Integer> getAllPlayerHeights();
}
