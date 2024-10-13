package service;

import entity.Match;
import entity.Player;
import model.GameScore;
import model.MatchScore;
import model.Set;
import repository.PlayerRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class OngoingMatchesService  {

    private static final Map<UUID, MatchScore> storage = new HashMap<>();
    private final PlayerRepository playerRepository;

    public OngoingMatchesService() {
        this.playerRepository = new PlayerRepository();
    }

    public MatchScore createNewMath(String player_1, String player_2) {
        Player player1 = findOrPersist(player_1);
        Player player2 = findOrPersist(player_2);

        var matchScore = buildMatchScore(player1, player2);
        var uuid = matchScore.getUuid();

        storage.put(uuid,matchScore);

        return matchScore;
    }


    private MatchScore buildMatchScore(Player player1, Player player2){
        var uuid = UUID.randomUUID();

        var match = Match.builder()
                .firstPlayer(player1)
                .secondPlayer(player2)
                .build();

        var gameScore = new GameScore(new Set());

        return new MatchScore(uuid,match,gameScore);
    }

    private Player findOrPersist(String playerName) {
        Player player;

        var optionalPlayer = playerRepository.findByName(playerName);

        if (optionalPlayer.isPresent()){
            player = optionalPlayer.get();
        }else {
            player = new Player();
            player.setName(playerName);
            playerRepository.save(player);
        }

        return player;
    }


    public Optional<MatchScore> getMatch(UUID uuid){
        return Optional.ofNullable(storage.get(uuid));
    }

    public void finishMatch(UUID uuid){
        storage.remove(uuid);
    }

}
