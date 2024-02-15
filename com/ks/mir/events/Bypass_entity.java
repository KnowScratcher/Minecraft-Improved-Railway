package com.ks.mir.events;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;

public class Bypass_entity implements Listener {

    @EventHandler
    public void onMinecartHit(VehicleEntityCollisionEvent e) {
        if (e.getVehicle().getType() == EntityType.MINECART) {
            if (Math.sqrt(Math.pow(e.getVehicle().getVelocity().getX(),2)+Math.pow(e.getVehicle().getVelocity().getY(),2)+Math.pow(e.getVehicle().getVelocity().getZ(),2)) > 2) {
                Entity entity = e.getEntity();
                if (entity instanceof Damageable) {
                    ((Damageable) entity).damage(100, e.getVehicle());
                }
                e.setCancelled(true);
            }
        }
    }

}
