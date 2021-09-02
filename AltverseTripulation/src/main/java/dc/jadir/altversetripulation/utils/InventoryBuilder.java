package dc.jadir.altversetripulation.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InventoryBuilder {

    private Inventory inv;

    private List<String> items = new ArrayList<>();
    private HashMap<Integer, ItemBuilder> itemsActions = new HashMap<>();

    public InventoryBuilder(int size, String name) {
        this.inv = Bukkit.createInventory(null, size, name);
    }

    public Inventory getInventory() {
        return inv;
    }

    public void setItem(ItemStack item, int index) {
        getInventory().setItem(index, item);
    }

    public HashMap<Integer,ItemBuilder> getItemsActions() { return itemsActions; }





}
