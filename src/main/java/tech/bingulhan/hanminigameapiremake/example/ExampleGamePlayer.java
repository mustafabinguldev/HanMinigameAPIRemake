package tech.bingulhan.hanminigameapiremake.example;

import lombok.Getter;
import tech.bingulhan.hanminigameapiremake.game.player.GamePlayer;

public class ExampleGamePlayer extends GamePlayer {


    @Getter
    private int exampleValue;

    public ExampleGamePlayer(String playerName, Integer exampleValue) {
        super(playerName);

        this.exampleValue = exampleValue;
    }
}
