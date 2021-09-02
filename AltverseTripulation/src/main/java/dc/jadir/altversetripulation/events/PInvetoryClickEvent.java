package dc.jadir.altversetripulation.events;

import dc.jadir.altversetripulation.AltverseTripulation;
import dc.jadir.altversetripulation.guis.LeaderGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class PInvetoryClickEvent implements Listener {

    private List<String> invetoryList = new ArrayList<>();

    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();

        invetoryList.add("Tripulação");
        invetoryList.add("Membros");

        invetoryList.forEach(invetoryName -> {
            if (inv.getName().equals(invetoryName)) {
                e.setCancelled(true);

                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Membros")) {
                    if (AltverseTripulation.tripulatorList.containsKey(player.getUniqueId().toString())) {

                        String tripName = AltverseTripulation.tripulatorList.get(player.getUniqueId().toString()).getTripName();
                        player.openInventory(new LeaderGUI(9 * 5, "Membros").membersList(AltverseTripulation.tripulationList.get(tripName)));

                    }
                }
            }
        });

    }

}
