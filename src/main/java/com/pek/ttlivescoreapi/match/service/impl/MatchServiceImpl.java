package com.pek.ttlivescoreapi.match.service.impl;

import com.pek.ttlivescoreapi.event.repository.MatchRepository;
import com.pek.ttlivescoreapi.match.entity.MatchPlayer;
import com.pek.ttlivescoreapi.match.service.MatchPlayerService;
import com.pek.ttlivescoreapi.match.service.MatchService;
import com.pek.ttlivescoreapi.match.service.PointService;
import com.pek.ttlivescoreapi.match.transport.MatchPlayerTransport;
import com.pek.ttlivescoreapi.user.mapper.UserMapper;
import com.pek.ttlivescoreapi.user.transport.UserTransport;

import java.util.List;

public class MatchServiceImpl implements MatchService {

    private MatchRepository matchRepository;
    private MatchPlayerService matchPlayerService;
    private PointService pointService;

    public MatchServiceImpl(MatchRepository matchRepository, MatchPlayerService matchPlayerService, PointService pointService) {
        this.matchRepository = matchRepository;
        this.matchPlayerService = matchPlayerService;
        this.pointService = pointService;
    }

    @Override
    public UserTransport getWinnerInASingleMatch(long singleMatchId) {

        List<MatchPlayerTransport> players = matchPlayerService.findAllByMatchId(singleMatchId);

        int player1Points = pointService.findAllByMatchIdAndPlayerId(singleMatchId, players.get(0).getPlayer().getId());
        int player2Points = pointService.findAllByMatchIdAndPlayerId(singleMatchId, players.get(1).getPlayer().getId());

        if(player1Points > player2Points) {
            return (players.get(0).getPlayer());
        }

        return players.get(1).getPlayer();
    }
}
