package service;

import entity.Match;
import repository.MatchRepository;

import java.util.List;

public class FinishedMatchesPersistenceService {
    private final MatchRepository matchRepository;

    public FinishedMatchesPersistenceService(){
        this.matchRepository = new MatchRepository();
    }

    public void persist(Match match){
        matchRepository.save(match);
    }

    public List<Match> findAllFinishedMatches(){
        return matchRepository.findAll();
    }

    public List<Match> findMatchByPlayer(String player){
        return matchRepository.findByPlayer(player);
    }

}
