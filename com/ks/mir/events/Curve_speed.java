package com.ks.mir.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class Curve_speed implements Listener {

    @EventHandler
    public void onMinecartMove(VehicleMoveEvent e) {
        if (e.getVehicle().getType() == EntityType.MINECART) {
            Minecart m = (Minecart) e.getVehicle();
        }
    }

}
