package com.atelier.tennisstats.service;

import com.atelier.tennisstats.model.Player;
import com.atelier.tennisstats.repository.TennisStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class TennisStatsService {

    @Autowired
    private TennisStatsRepository tennisStatsRepository;

    public List<Player> getAllPlayers() {
        return tennisStatsRepository.getAllPlayer()
                .stream()
                .sorted(Comparator.comparingInt(player->player.getData().getRank()))
            .collect(Collectors.toList());
    }


    public Player getPlayerById(int id) {
        return tennisStatsRepository.getPlayerById(id);
    }

    public String getBestRatioCountry() {
        Map<String, Double> countryRatioMap = new HashMap<>();
        List<Player> players = tennisStatsRepository.getAllPlayer();

        for (Player player : players) {
            String country = player.getCountry().getCode();
            int gamesPlayed = player.getData().getLast().length;
            int gamesWon = 0;
            for (int score : player.getData().getLast()) {
                if (score > 0) {
                    gamesWon++;
                }
            }
            double ratio = (double) gamesWon / gamesPlayed;
            if (countryRatioMap.containsKey(country)) {
                double existingRatio = countryRatioMap.get(country);
                if (ratio > existingRatio) {
                    countryRatioMap.put(country, ratio);
                }
            } else {
                countryRatioMap.put(country, ratio);
            }
        }

        String bestRatioCountry = Collections.max(countryRatioMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        return bestRatioCountry;
    }

    public double getAverageIMC() {
        List<Player> players = tennisStatsRepository.getAllPlayer();
        double totalIMC = 0.0;
        int count = 0;
        for (Player player : players) {
            if (player.getData().getHeight() > 0 && player.getData().getWeight() > 0) {
                double heightInMeters = player.getData().getHeight() / 100.0;
                double weightInKilos = player.getData().getWeight();
                double imc = weightInKilos / (heightInMeters * heightInMeters);
                totalIMC += imc;
                count++;
            }
        }
        return totalIMC / count;
    }

    public double getMedianPlayerHeight() {
        List<Integer> heights = tennisStatsRepository.getAllPlayerHeights();
        Collections.sort(heights);
        int size = heights.size();
        if (size % 2 == 0) {
            int index = size / 2;
            return (heights.get(index - 1) + heights.get(index)) / 2.0;
        } else {
            return heights.get(size / 2);
        }
    }
}
