package tech.bingulhan.hanminigameapiremake.example.states.one;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import tech.bingulhan.hanminigameapiremake.example.ExampleGamePlayer;
import tech.bingulhan.hanminigameapiremake.game.state.GameState;
import tech.bingulhan.hanminigameapiremake.game.state.listener.GameStateListener;

public class OneStateListener extends GameStateListener {
    public OneStateListener(GameState state) {
        super(state);
    }


    @EventHandler
    public void onJoinEvent(PlayerLoginEvent event) {
        getState().getGame().addPlayer(new ExampleGamePlayer(event.getPlayer().getName(), 2023));
    }


    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        if (isPlayerInGame(event.getPlayer().getName())) {
            event.setCancelled(true);
        }
    }


}
