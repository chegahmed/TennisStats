package com.atelier.tennisstats.repository;

import com.atelier.tennisstats.model.Player;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Repository
public class TennisStatsRepositoryImpl implements TennisStatsRepository {
    private List<Player> players;

    @Value("${api.path}")
    private String apiPath;

    public TennisStatsRepositoryImpl() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> response = restTemplate.getForEntity("https://data.latelier.co/training/tennis_stats/headtohead.json", String.class);

        JSONObject jsonObject = new JSONObject(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        players = objectMapper.readValue(jsonObject.getJSONArray("players").toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));

    }

    @Override
    public List<Player> getAllPlayer() {
        return players;
    }

    @Override
    public Player getPlayerById(int id) {
        return getAllPlayer().stream()
                .filter(player -> player.getId() == id)
                .findFirst()
                .orElse(null);    }


    @Override
    public List<Integer> getAllPlayerHeights() {
        List<Integer> heights = new ArrayList<>();
        for (Player player : players) {
            heights.add(player.getData().getHeight());
        }
        return heights;
    }

}
