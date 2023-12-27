package com.pek.ttlivescoreapi.team.controller;

import com.pek.ttlivescoreapi.team.exception.TeamAlreadyExistException;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.service.TeamService;
import com.pek.ttlivescoreapi.team.tansport.TeamCreateTransport;
import com.pek.ttlivescoreapi.team.tansport.TeamQueryTransport;
import com.pek.ttlivescoreapi.team.tansport.TeamShortTransport;
import com.pek.ttlivescoreapi.team.tansport.TeamTransport;
import com.pek.ttlivescoreapi.user.service.UserService;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teams")
public class TeamController {

    private final TeamService teamService;
    private final UserService userService;


    public TeamController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }

    public TeamTransport findById(@PathVariable long id) throws TeamNotFoundException {
        return teamService.findById(id);
    }

    @GetMapping("")
    public List<TeamShortTransport> findAll(@RequestParam(required = false) TeamQueryTransport query) {
        return teamService.findAll(query);
    }

    @GetMapping("/{name}")
    public TeamTransport findByTeamName(@PathVariable String name) throws TeamNotFoundException {
        return teamService.findByName(name);
    }

    @PostMapping("")
    public TeamShortTransport save(@RequestBody TeamCreateTransport team) throws TeamAlreadyExistException {
        return teamService.save(team);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) throws TeamNotFoundException {
        teamService.deleteById(id);
    }

    @GetMapping("{teamName}/players")
    public List<UserTransport> findAllPlayerByTeamName(@PathVariable String teamName) {
        return userService.findAllByTeamName(teamName);
    }


}
