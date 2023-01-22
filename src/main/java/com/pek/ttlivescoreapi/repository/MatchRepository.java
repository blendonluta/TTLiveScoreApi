package com.pek.ttlivescoreapi.repository;

import com.pek.ttlivescoreapi.entity.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> findAllByEventId(long eventId);

}
