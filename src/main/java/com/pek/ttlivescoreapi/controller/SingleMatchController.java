package com.pek.ttlivescoreapi.controller;


import com.pek.ttlivescoreapi.entity.User;
import com.pek.ttlivescoreapi.service.SingleMatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("singleMatch")
public class SingleMatchController {

    private SingleMatchService service;

    public SingleMatchController(SingleMatchService service) {
        this.service = service;
    }


    @GetMapping("/{singleMatchId}/{playerId}")
    public int getPlayerPointsInASingleMatch(@PathVariable long singleMatchId, @PathVariable long playerId) {
        return service.getPlayersPointInASingleMatch(singleMatchId, playerId);
    }
}
