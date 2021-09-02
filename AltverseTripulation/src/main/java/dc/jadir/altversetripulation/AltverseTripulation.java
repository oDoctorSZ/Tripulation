package dc.jadir.altversetripulation;

import dc.jadir.altversetripulation.events.PInvetoryClickEvent;
import dc.jadir.altversetripulation.manager.CommandManager;
import dc.jadir.altversetripulation.references.Tripulation;
import dc.jadir.altversetripulation.references.Tripulator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class AltverseTripulation extends JavaPlugin {

    public static HashMap<String, Tripulation> tripulationList = new HashMap();
    public static HashMap<String, Tripulator> tripulatorList = new HashMap();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PInvetoryClickEvent(), this);
        getCommand("trip").setExecutor(new CommandManager());
    }

    @Override
    public void onDisable() {


    }

}
