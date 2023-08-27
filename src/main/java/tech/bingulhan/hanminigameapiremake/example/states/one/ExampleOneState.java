package tech.bingulhan.hanminigameapiremake.example.states.one;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import tech.bingulhan.hanminigameapiremake.game.GameVariant;
import tech.bingulhan.hanminigameapiremake.game.player.GamePlayer;
import tech.bingulhan.hanminigameapiremake.game.state.GameState;

public class ExampleOneState extends GameState {
    public ExampleOneState(GameVariant game) {
        super(game);
    }

    @Override
    public void onStart() {

        Bukkit.getLogger().info("State -> ONE ");
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (isPlayerInGame(onlinePlayer.getName())) {
                onlinePlayer.sendMessage("State 1");
            }
        }

        getListeners().add(new OneStateListener(this));


    }

    @Override
    public void onStop() {
        getGame().nextState();
    }

    @Override
    public void onJoinPlayer(GamePlayer player) {
        // Yapım aşamasında
        // the under construction
    }

    @Override
    public void onQuitPlayer(GamePlayer player) {
        // the under construction
        //Yapım Aşamasında
    }
}