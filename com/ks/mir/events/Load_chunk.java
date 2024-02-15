package com.ks.mir.events;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class Load_chunk implements Listener {

    @EventHandler
    public void onMinecartMove(VehicleMoveEvent e) {
        if (e.getVehicle().getType() == EntityType.MINECART) {
            Location loc = e.getTo();
            Chunk cl = e.getFrom().getChunk();
            cl.load();
            cl.setForceLoaded(false);
            Chunk cn = loc.getChunk();
            cn.load();
            cn.setForceLoaded(true);
            //System.out.println(e.getVehicle().getVelocity());
            //System.out.println(loc);
        }
    }
}
