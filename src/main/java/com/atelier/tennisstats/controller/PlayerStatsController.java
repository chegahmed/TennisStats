package com.atelier.tennisstats.controller;

import com.atelier.tennisstats.model.Country;
import com.atelier.tennisstats.model.Player;
import com.atelier.tennisstats.service.TennisStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerStatsController {


    @Autowired
    private TennisStatsService tennisStatsService;

    @GetMapping("/sorted")
    public List<Player> getSortedPlayers() {
        List<Player> players = tennisStatsService.getAllPlayers();
        return players;
    }


    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return tennisStatsService.getPlayerById(id);
    }


    @GetMapping("/countries/ratio")
    public ResponseEntity<String> getBestRatioCountry() {
        String bestRatioCountry = tennisStatsService.getBestRatioCountry();
        return ResponseEntity.ok().body("Le pays avec le plus grand ratio de parties gagnées est " + bestRatioCountry);
    }


    @GetMapping("/average-imc")
    public ResponseEntity<String> getAverageIMC() {
        double averageIMC = tennisStatsService.getAverageIMC();
        return ResponseEntity.ok().body("L'IMC moyen de tous les joueurs est " + averageIMC);
    }

    @GetMapping("/median-player-height")
    public ResponseEntity<Double> getMedianPlayerHeight() {
        return ResponseEntity.ok().body(tennisStatsService.getMedianPlayerHeight());
    }


}
