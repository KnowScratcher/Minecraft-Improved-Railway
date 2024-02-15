package com.ks.mir;

import com.ks.mir.controls.Deport;
import com.ks.mir.controls.Rails;
import com.ks.mir.events.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Mir extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new Load_chunk(),this);
        pluginManager.registerEvents(new Create_deport(this),this);
        pluginManager.registerEvents(new Set_cart_speed(),this);
        pluginManager.registerEvents(new Reject_enter(),this);
        pluginManager.registerEvents(new Bypass_entity(),this);
        pluginManager.registerEvents(new Show_speed(),this);
        pluginManager.registerEvents(new Control_panel(),this);
        Rails.setup();
        Rails.records.options().copyDefaults(true);
        Rails.save();
        Deport.setup();
        Deport.records.options().copyDefaults(true);
        Deport.save();
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA+"[MIR] Minecraft Improved Railway loaded");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED+"[MIR] Minecraft Improved Railway unloaded");
    }

}
