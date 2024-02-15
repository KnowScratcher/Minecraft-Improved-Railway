package com.ks.mir.controls;

import com.sun.source.tree.UsesTree;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Deport_to_rail {

    private static File file;
    private static FileConfiguration links;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Minecraft_Improved_Railway").getDataFolder(),"links.yml");
        if (!file.exists()) {
            try{
                file.createNewFile();
            }catch (IOException e){
                //lol
            }
        }
        links = YamlConfiguration.loadConfiguration(file);
    }

    public static void save() {
        try {
            links.save(file);
        }catch (IOException e) {
            System.out.println("can't find path");
        }
    }

    public static Location getStart(Location deport) {
        String key = String.valueOf(deport.getX()) +
                deport.getY() +
                deport.getZ();
        return links.getLocation(key);
    }

    public static String getDirection(Location deport) {
        String key = String.valueOf(deport.getX()) +
                deport.getY() +
                deport.getZ() +
                "_dir";
        return links.getString(key);
    }

    public static void addLink(Location deport,Location start,String direction) {
        String key = String.valueOf(deport.getX()) +
                deport.getY() +
                deport.getZ();
        String key2 = key+"_dir";
        links.set(key,start);
        links.set(key2,direction);
        save();
    }
}
