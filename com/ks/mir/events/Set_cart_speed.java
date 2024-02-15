package com.ks.mir.events;

import com.ks.mir.controls.Constants;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class Set_cart_speed implements Listener {

    @EventHandler
    public void onMinecartSpawn(EntitySpawnEvent e) {
        if (e.getEntityType() == EntityType.MINECART) {
            System.out.println("spawn");
            Minecart m = (Minecart) e.getEntity();
            m.setMaxSpeed(Constants.speed);
        }
    }

}
