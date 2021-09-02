package dc.jadir.altversetripulation.manager;

import dc.jadir.altversetripulation.commands.TripCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (command.getName().equalsIgnoreCase("trip")) {
                new TripCommands().execute(sender, command, args);
            }

        }
        return false;
    }
}
