package com.ks.mir.events;

import com.ks.mir.Mir;
import com.ks.mir.actions.Findpath;
import com.ks.mir.controls.Deport;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Create_deport implements Listener {

    private final Mir plugin;

    public Create_deport(Mir plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (e.getBlockPlaced().getType() == Material.CHEST) {
            if (e.getBlockPlaced().getLocation().add(0,-1,0).getBlock().getType() == Material.GOLD_BLOCK) {
                e.getPlayer().sendMessage(ChatColor.GREEN+"你剛剛創建了一個車廠");
                Deport.add(e.getBlockPlaced().getLocation());
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        Location rail_start = Findpath.findStart(e.getPlayer(),e.getBlockPlaced().getLocation(), ((Directional)e.getBlock().getBlockData()).getFacing().toString());
                    }
                });
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.CHEST) {
            if (Arrays.asList(Deport.locations).contains(e.getBlock().getLocation())) {
                e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "你剛剛移除了一個車廠");
                Deport.remove(e.getBlock().getLocation());
            }
        } else if (e.getBlock().getType() == Material.GOLD_BLOCK) {
            if (Arrays.asList(Deport.locations).contains(e.getBlock().getLocation().add(0,1,0))) {
                e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "你剛剛移除了一個車廠");
                Deport.remove(e.getBlock().getLocation().add(0,1,0));
            }
        }
    }

}
