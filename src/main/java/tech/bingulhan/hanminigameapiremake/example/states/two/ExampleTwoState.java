package tech.bingulhan.hanminigameapiremake.example.states.two;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import tech.bingulhan.hanminigameapiremake.game.GameVariant;
import tech.bingulhan.hanminigameapiremake.game.player.GamePlayer;
import tech.bingulhan.hanminigameapiremake.game.state.GameState;

public class ExampleTwoState extends GameState {
    public ExampleTwoState(GameVariant game) {
        super(game);
    }

    @Override
    public void onStart() {

        Bukkit.getLogger().info("State -> TWO ");
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (isPlayerInGame(onlinePlayer.getName())) {
                onlinePlayer.sendMessage("State 2");
            }
        }

        getListeners().add(new TwoStateListener(this));


    }

    @Override
    public void onStop() {
        getGame().stop();
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