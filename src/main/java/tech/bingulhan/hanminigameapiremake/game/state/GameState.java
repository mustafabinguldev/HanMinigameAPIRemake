package tech.bingulhan.hanminigameapiremake.game.state;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import tech.bingulhan.hanminigameapiremake.game.GameVariant;
import tech.bingulhan.hanminigameapiremake.game.player.GamePlayer;
import tech.bingulhan.hanminigameapiremake.game.state.listener.GameStateListener;

import java.util.HashSet;

@Getter
public abstract class GameState {

    private GameVariant game;

    private HashSet<GameStateListener> listeners;
    public GameState(GameVariant game) {
        this.game = game;
        listeners = new HashSet<>();
    }

    public final void start() {

        onStart();
        for (GameStateListener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, game.getPlugin());
        }

    }

    public final void stop() {

        onStop();

        for (GameStateListener listener : listeners) {
            HandlerList.unregisterAll(listener);
        }

    }

    public abstract void onStart();
    public abstract void onStop();

    public abstract void onJoinPlayer(GamePlayer player);
    public abstract void onQuitPlayer(GamePlayer player);

    public final boolean isPlayerInGame(String player) {
        return game.getPlayers().stream().anyMatch(g -> g.getPlayerName().equals(player));
    }
}
