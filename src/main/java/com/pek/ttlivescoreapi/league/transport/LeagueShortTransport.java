package com.pek.ttlivescoreapi.league.transport;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeagueShortTransport {
    private long id;
    private String name;
    private String category;
    private long year;
    private long teamsLength;
}
