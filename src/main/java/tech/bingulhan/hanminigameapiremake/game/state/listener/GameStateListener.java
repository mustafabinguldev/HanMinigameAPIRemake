package tech.bingulhan.hanminigameapiremake.game.state.listener;

import lombok.Getter;
import org.bukkit.event.Listener;
import tech.bingulhan.hanminigameapiremake.game.state.GameState;

@Getter
public  abstract class GameStateListener implements Listener {

    private GameState state;

    public GameStateListener(GameState state) {
        this.state = state;
    }
    public boolean isPlayerInGame(String player) {
        return state.isPlayerInGame(player);
    }
}
