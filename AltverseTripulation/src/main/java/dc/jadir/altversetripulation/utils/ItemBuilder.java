package dc.jadir.altversetripulation.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private final short damage = 0;

    private ItemStack item;
    private ItemMeta meta;
    private String itemName;
    private List<String> lore = new ArrayList<>();
    private List<String> commands = new ArrayList<>();

    public ItemBuilder(String displayName, int id, int data) {
        item = new ItemStack(id, 1, damage, (byte) data);
        meta = item.getItemMeta();
        this.itemName = displayName;
        meta.setDisplayName(displayName);
        item.setItemMeta(meta);
    }

    public ItemBuilder(int id, int data) {
        item = new ItemStack(id, 1, damage, (byte) data);
    }

    public void setLore(String... lore) {
        List<String> loreList = new ArrayList<>();
        for (String s : lore) {
            loreList.add(s.replace("&", "ยง"));
        }
        this.lore = loreList;
        meta.setLore(loreList);
        meta.setDisplayName(itemName);
        item.setItemMeta(meta);
    }

    public void addLore(String loreItem) {
        String newLore = loreItem.replace("&", "ยง");

        lore.add(newLore);
        meta.setLore(this.lore);
        meta.setDisplayName(itemName);
        item.setItemMeta(meta);
    }


    public void setLore(List<String> lore) {
        List<String> newLore = new ArrayList<>();
        lore.forEach(item -> {
            newLore.add(item.replace("&","ยง"));
        });
        this.lore = newLore;
        meta.setLore(newLore);
        meta.setDisplayName(itemName);
        item.setItemMeta(meta);
    }

    public ItemStack getItem() {
        return item;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public List<String> getCommmands(){
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public String getName() {
        return itemName;
    }
}
