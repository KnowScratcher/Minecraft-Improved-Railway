package com.ks.mir.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class Reject_enter implements Listener {

    @EventHandler
    public void onEnterMinecart(VehicleEnterEvent e) {
        if (e.getVehicle().getType() == EntityType.MINECART) {
            if (!e.getEntered().hasPermission("mir.enter")) {
                e.setCancelled(true);
                e.getEntered().sendMessage(ChatColor.RED+"你不能這樣進入");
            }
        }
    }
}
