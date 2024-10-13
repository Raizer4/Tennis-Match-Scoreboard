package model;

import entity.Match;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class MatchScore {

    private final UUID uuid;
    private final Match match;
    private final GameScore gameScore;

    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;
    private int firstPlayerAce = 0;
    private int secondPlayerAce = 0;

    public int getPlayerNumber(Long id){
        return match.getFirstPlayer().getId().equals(id) ? 1 : 2;
    }

}
