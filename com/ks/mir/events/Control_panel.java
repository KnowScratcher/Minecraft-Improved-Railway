package com.ks.mir.events;

import com.ks.mir.controls.Deport;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Control_panel implements Listener {

    @EventHandler
    public void onDeportClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && !e.getPlayer().isSneaking() && Arrays.asList(Deport.locations).contains(e.getClickedBlock().getLocation())) {
            e.setCancelled(true);
            Player player = e.getPlayer();
            Inventory panel_main = Bukkit.createInventory(player,9,ChatColor.BLUE+"鐵路控制台");

            ItemStack refresh = new ItemStack(Material.GREEN_CONCRETE);
            ItemStack clear = new ItemStack(Material.MINECART);

            ItemMeta refresh_meta = refresh.getItemMeta();
            refresh_meta.setDisplayName(ChatColor.GREEN+"規劃路線");
            refresh.setItemMeta(refresh_meta);

            ItemMeta clear_meta = clear.getItemMeta();
            clear_meta.setDisplayName(ChatColor.RED+"清除列車");
            clear.setItemMeta(clear_meta);

            ItemStack[] contain_main = {refresh,clear};
            panel_main.setContents(contain_main);
            player.openInventory(panel_main);
        }
    }

    @EventHandler
    public void onPanelClicked(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE+"鐵路控制台")) {
            if (e.getCurrentItem() != null) {
                player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BELL,1.0f,1.0f);
                switch (e.getCurrentItem().getItemMeta().getDisplayName().toString()) {
                    case "§a規劃路線":
                        //lol
                        break;
                    case "§c清除列車":
                        //lol
                        break;
                }
            }


            e.setCancelled(true);
        }
    }

}
