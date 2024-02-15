package com.ks.mir.controls;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Rails {

    private static File file;
    public static FileConfiguration records;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Minecraft_Improved_Railway").getDataFolder(),"rails.yml");
        if (!file.exists()) {
            try{
                file.createNewFile();
            }catch (IOException e){
                //lol
            }
        }
        records = YamlConfiguration.loadConfiguration(file);

    }

    public static void save() {
        try {
        records.save(file);
        }catch (IOException e) {
            //lol
        }
    }

    public static Location[] getNodes(Location location) {
        String key = String.valueOf(location.getX()) +
                location.getY() +
                location.getZ();
        List<?> l = records.getList(key);
        if (l != null) {
            Object[] nodes_obj = l.toArray();
            Location[] nodes = new Location[nodes_obj.length];
            for (int i = 0; i < nodes_obj.length; i++) {
                nodes[i] = (Location) nodes_obj[i];
            }
            return nodes;
        }
        return null;
    }

    /**
     * need to add save()
     */
    public static void add(Location node,Location start) {

        Location[] old = getNodes(start);
        assert old != null;
        Location[] nodes = new Location[old.length+1];
        nodes[nodes.length-1] = node;
        String key = String.valueOf(start.getX()) +
                start.getY() +
                start.getZ();
        records.set(key,nodes);
    }

    /**
     * need to add save()
     */
    public static void reset(Location start) {

        Location[] nodes = new Location[1];
        nodes[0] = start;
        String key = String.valueOf(start.getX()) +
                start.getY() +
                start.getZ();
        records.set(key,nodes);
    }

    /**
     * need to add save()
     */
    public static void delete(Location start) {
        String key = String.valueOf(start.getX()) +
                start.getY() +
                start.getZ();
        records.set(key,null);
    }

}
