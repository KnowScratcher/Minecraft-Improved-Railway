package com.ks.mir.controls;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Deport {

    private static File file;
    public static FileConfiguration records;
    public static Location[] locations;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Minecraft_Improved_Railway").getDataFolder(),"deports.yml");
        if (!file.exists()) {
            try{
                file.createNewFile();
            }catch (IOException e){
                //lol
            }
        }
        records = YamlConfiguration.loadConfiguration(file);
        try {
            Object[] locations_obj = Deport.records.getList("deports").toArray();
            Location[] location = new Location[locations_obj.length];
            for (int i=0;i<locations_obj.length;i++) {
                location[i] = (Location) locations_obj[i];
            }
            locations = location;
        }catch (NullPointerException e2) {
            locations = new Location[]{};
        }

    }

    public static void save() {
        try {
            records.set("deports",locations);
            records.save(file);
        }catch (IOException e) {
            System.out.println("can't save deports");
        }
    }

    public static void add(Location l) {
        Location[] new_locations = Arrays.copyOf(locations,locations.length+1);
        new_locations[new_locations.length-1] = l;
        locations = new_locations;
        save();
    }

    public static void remove(Location l) {
        Location[] new_locations = new Location[locations.length-1];
        int k=0;
        if (locations.length>1) {
            for (int i = 0; i < locations.length; i++) {
                if (!locations[i].equals(l)) {
                    new_locations[k] = locations[i];
                    k++;
                }
            }
        }else {
            locations = new Location[]{};
        }
        locations = new_locations;
        save();
    }

}
