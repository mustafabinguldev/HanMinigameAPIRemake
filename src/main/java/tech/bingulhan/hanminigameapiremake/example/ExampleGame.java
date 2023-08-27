package tech.bingulhan.hanminigameapiremake.example;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tech.bingulhan.hanminigameapiremake.example.states.one.ExampleOneState;
import tech.bingulhan.hanminigameapiremake.example.states.two.ExampleTwoState;
import tech.bingulhan.hanminigameapiremake.game.GameVariant;

public class ExampleGame extends GameVariant {

    public ExampleGame(String gameName, JavaPlugin plugin) {
        super(gameName, plugin);
    }

    @Override
    public void onEnable() {

        Bukkit.getLogger().info("Game loading...");


        getStates().add(new ExampleOneState(this));
        getStates().add(new ExampleTwoState(this));




        setState(1);


    }

    @Override
    public void onDisable() {

    }
}
