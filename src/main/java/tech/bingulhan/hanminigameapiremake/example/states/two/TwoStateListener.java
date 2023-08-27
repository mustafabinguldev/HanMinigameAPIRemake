package tech.bingulhan.hanminigameapiremake.example.states.two;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import tech.bingulhan.hanminigameapiremake.game.state.GameState;
import tech.bingulhan.hanminigameapiremake.game.state.listener.GameStateListener;

public class TwoStateListener extends GameStateListener {

    public TwoStateListener(GameState state) {
        super(state);
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        if (isPlayerInGame(event.getPlayer().getName())) {
            event.setCancelled(true);
        }
    }
}
