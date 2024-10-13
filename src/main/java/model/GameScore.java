package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GameScore {

    private final Set setScore;
    private int firstPlayerGame = 0;
    private int secondPlayerGame = 0;
}
