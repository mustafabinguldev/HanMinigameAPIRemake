package tech.bingulhan.hanminigameapiremake.game;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import tech.bingulhan.hanminigameapiremake.game.player.GamePlayer;
import tech.bingulhan.hanminigameapiremake.game.state.GameState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


@Getter
public abstract class GameVariant {

    private String gameName;
    private HashSet<GamePlayer> players;
    private JavaPlugin plugin;


    private GameState currentState;
    private List<GameState> states;

    private int stateNumber;

    public GameVariant(String gameName, JavaPlugin plugin) {
        this.gameName = gameName;
        this.plugin = plugin;
        players = new HashSet<>();
        states = new ArrayList<>();
    }

    public abstract void onEnable();
    public abstract void onDisable();


    public final void start() {
        onEnable();

        if (currentState==null) {
            return;
        }

        currentState.start();

    }

    public final void stop() {


        if (currentState!=null) {
            currentState.stop();
        }

        onDisable();

    }

    public final void nextState() {

        if (stateNumber+1>states.size()) {
            stop();
        }else{

            currentState = states.get(stateNumber);
            currentState.start();


        }

    }
    public final void setCurrentState(GameState newState) {
        this.currentState = newState;
    }

    public final void setState(int id) {
        this.stateNumber = id;
    }

    public final void addPlayer(GamePlayer player) {

        if (player==null) {
            return;
        }

        players.add(player);

        if (currentState!=null) {
            currentState.onJoinPlayer(player);
        }

    }

    public final void removePlayer(GamePlayer player) {

        if (player==null) {
            return;
        }
        players.remove(player);

        if (currentState!=null) {
            currentState.onQuitPlayer(player);
        }

    }

    public final Optional<GamePlayer> getPlayer(String playerName) {
        return players.stream().filter(player -> player.getPlayerName().equals(playerName)).findAny();
    }




}

