package org.lantern;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.lantern.Sphere.Sphere;

public class Lantern extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.TORCH) {
            Block torch = event.getBlock();
            Location torchLoc = torch.getLocation();
            Sphere Light = new Sphere(5, Material.LIGHT);
            Light.generateSphere(torchLoc);
        }
    }
}

