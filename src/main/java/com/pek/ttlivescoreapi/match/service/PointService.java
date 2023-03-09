package com.pek.ttlivescoreapi.match.service;

import com.pek.ttlivescoreapi.match.entity.Point;
import com.pek.ttlivescoreapi.event.repository.PointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PointService {
    int findAllByMatchIdAndPlayerId(long matchId, long playerId);
}
