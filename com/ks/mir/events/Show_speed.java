package com.ks.mir.events;

import com.ks.mir.controls.Globals;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class Show_speed implements Listener {

    public double showOnePoint(double d) {
        return Math.round(d*10.0)/10.0;
    }

    @EventHandler
    public void onMinecartMove(VehicleMoveEvent e) {
        System.out.println(Math.abs(Math.sqrt(Math.pow(e.getVehicle().getVelocity().getX(), 2) + Math.pow(e.getVehicle().getVelocity().getY(), 2) + Math.pow(e.getVehicle().getVelocity().getZ(), 2))));
        System.out.println(e.getVehicle().getVelocity());
        double speed = e.getFrom().distance(e.getTo());
        double new_speed = showOnePoint(Math.max(speed,Globals.last_tick_speed));
        Globals.last_tick_speed = speed;
        try {
            if (e.getVehicle().getPassengers().get(0) instanceof Player player) {
                player.sendTitle("測試", "速度:" + new_speed * 20 + "m/s, " + showOnePoint(new_speed * 20 * 3.6) + "km/h", 0, 10, 10);
            }
        }catch (IndexOutOfBoundsException e2) {
            //shut the fuck up
        }

    }

}
