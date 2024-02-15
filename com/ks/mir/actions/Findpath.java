package com.ks.mir.actions;

import com.ks.mir.controls.Constants;
import com.ks.mir.controls.Deport_to_rail;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;

public class Findpath {

    public static Location findStart(Player player, Location deport, String facing) {
        Location location = deport.clone();
        int dx = 0;
        int dz = 0;
        switch (facing) {
            case "NORTH" -> {
                dz = -1;
            }
            case "SOUTH" -> {
                dz = 1;
            }
            case "EAST" -> {
                dx = 1;
            }
            case "WEST" -> {
                dx = -1;
            }
        }
        if (location.add(dx,0,dz).getBlock().getType() == Material.POWERED_RAIL && location.add(dx,0,dz).getBlock().getType() == Material.POWERED_RAIL) {
            player.sendMessage(ChatColor.GREEN+"已找到找到出發點");
            Minecart m = ((Minecart)location.getWorld().spawnEntity(location.add(-1.5*dx,0,-1.5*dz), EntityType.MINECART));
            m.setMaxSpeed(Constants.speed);
            m.setInvulnerable(true);
            location.add(0.5*dx,0,0.5*dz);
            Deport_to_rail.addLink(deport,location,facing);
            return location;
        }
        return null;
    }

    public static Location[] findpath(Location location) {

    }

}
