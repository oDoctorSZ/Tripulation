package dc.jadir.altversetripulation.commands;

import dc.jadir.altversetripulation.AltverseTripulation;
import dc.jadir.altversetripulation.enums.Role;
import dc.jadir.altversetripulation.guis.LeaderGUI;
import dc.jadir.altversetripulation.references.CommandBase;
import dc.jadir.altversetripulation.references.Tripulation;
import dc.jadir.altversetripulation.references.Tripulator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class TripCommands extends CommandBase {

    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
             player.openInventory(new LeaderGUI(9 * 5, "Tripulação").gui(new Tripulation("Ola", player.getUniqueId().toString(), 0, 0, new ArrayList<>())));
        } else {
            if (args.length != 2 || !args[0].equals("criar")) {
                player.sendMessage("Sintaxe error!");
            } else {
                String tripname = args[1];

                if (AltverseTripulation.tripulationList.containsKey(tripname.toUpperCase())) {
                    player.sendMessage("Já EXISTe");
                } else {
                    AltverseTripulation.tripulationList.put(tripname.toUpperCase(), new Tripulation(tripname.toUpperCase(), player.getUniqueId().toString(), 0, 0, Arrays.asList(player.getUniqueId().toString())));
                    AltverseTripulation.tripulatorList.put(player.getUniqueId().toString(), new Tripulator(player.getUniqueId().toString(), player.getDisplayName(), tripname.toUpperCase(), Role.CAPTAIN));

                }

            }
        }

    }

}
