package tech.bingulhan.hanminigameapiremake.game.player;

import lombok.Getter;

@Getter
public class GamePlayer {

    private String playerName;

    public GamePlayer(String playerName) {
        this.playerName = playerName;
    }
}
