package com.qubiccms;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class QubicCmsPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        LOGGER.log(Level.INFO, "Enable plugin");
    }

    @Override
    public void onDisable() {
        LOGGER.log(Level.INFO, "Disable plugin");
        super.onDisable();
    }

    @Override
    public void onLoad() {
        LOGGER.log(Level.INFO, "Load plugin");
        super.onLoad();
    }
}
