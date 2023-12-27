package com.pek.ttlivescoreapi.team.service;

import com.pek.ttlivescoreapi.team.exception.TeamAlreadyExistException;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.tansport.TeamCreateTransport;
import com.pek.ttlivescoreapi.team.tansport.TeamQueryTransport;
import com.pek.ttlivescoreapi.team.tansport.TeamShortTransport;
import com.pek.ttlivescoreapi.team.tansport.TeamTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    TeamTransport findById(long id) throws TeamNotFoundException;

    TeamTransport findByName(String name) throws TeamNotFoundException;

    TeamShortTransport save(TeamCreateTransport newTeam) throws TeamAlreadyExistException;

    void deleteById(long id) throws TeamNotFoundException;

    List<TeamTransport> findAllByLeagueId(long leagueId);

    List<TeamShortTransport> findAll(TeamQueryTransport query);
}
