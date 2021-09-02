package dc.jadir.altversetripulation.guis;

import dc.jadir.altversetripulation.AltverseTripulation;
import dc.jadir.altversetripulation.references.Tripulation;
import dc.jadir.altversetripulation.references.Tripulator;
import dc.jadir.altversetripulation.utils.ChatUtil;
import dc.jadir.altversetripulation.utils.InventoryBuilder;
import dc.jadir.altversetripulation.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaderGUI extends InventoryBuilder {

    private ItemBuilder item;
    private List<ItemBuilder> items = new ArrayList<>();

    public LeaderGUI(int size, String name) {
        super(size, name);
    }

    public Inventory gui(Tripulation tripulation) {

        items.add(new ItemBuilder("Tripulação", 340, 0));
        items.add(new ItemBuilder("Recompensas", 266, 0));
        items.add(new ItemBuilder("Bonus", 54, 0));
        items.add(new ItemBuilder("Membros", 397, 3));

        items.forEach(item -> {
            if (item.getName().equals("Tripulação")) {

                item.setLore(ChatUtil.format("Nome: " + tripulation.getName()),
                        ChatUtil.format("Dinheiro: " + tripulation.getCash()),
                        ChatUtil.format("Membros: " + tripulation.getMembers().size()));

                setItem(item.getItem(), 13);
            } else if(item.getName().equals("Recompensas")) {
                setItem(item.getItem(), 29);
            } else if(item.getName().equals("Bonus")) {
                setItem(item.getItem(), 33);
            } else if(item.getName().equals("Membros")) {
                setItem(item.getItem(), 31);
            }
        });

        return getInventory();
    }

    public Inventory membersList(Tripulation tripulation) {

        tripulation.getMembers().forEach(member -> {

            if (member != null) {
                for (int i = 0; i < tripulation.getMembers().size(); i++) {

                    List<String> lore = new ArrayList<>();

                    ItemStack item = new ItemStack(getPlayerHead(AltverseTripulation.tripulatorList.get(member).getNick()));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(AltverseTripulation.tripulatorList.get(member).getNick());

                    lore.add("Role: " + AltverseTripulation.tripulatorList.get(member).getRole());
                    lore.add(ChatUtil.format("&2Botão Esquedo para promover um membro!"));
                    lore.add(ChatUtil.format("&aBotão Direto para remover um membro!"));

                    itemMeta.setLore(lore);
                    item.setItemMeta(itemMeta);

                    getInventory().setItem(i, item);

                    //setItem(getPlayerHead(Bukkit.getPlayer(AltverseTripulation.tripulatorList.get(member).getPlayer()).getDisplayName()), i);

                }
            }

        });


        return getInventory();
    }

    @SuppressWarnings("deprecation")
    public static ItemStack getPlayerHead(String player) {

        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

        SkullMeta skullMeta = (SkullMeta) item.getItemMeta();

        skullMeta.setOwner(player);
        skullMeta.setDisplayName(player);

        item.setItemMeta(skullMeta);

        return item;
    }

}
