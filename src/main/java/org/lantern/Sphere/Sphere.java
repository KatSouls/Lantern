package org.lantern.Sphere;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Sphere {
    private int radius;
    private Material blockType;

    public Sphere(int radius, Material blockType) {
        this.radius = radius;
        this.blockType = blockType;
    }

    public void generateSphere(Location center) {
        World world = center.getWorld();
        int cx = center.getBlockX();
        int cy = center.getBlockY();
        int cz = center.getBlockZ();

        for (int x = cx - radius; x <= cx + radius; x++) {
            for (int y = cy - radius; y <= cy + radius; y++) {
                for (int z = cz - radius; z <= cz + radius; z++) {
                    Location loc = new Location(world, x, y, z);
                    if (loc.distance(center) <= radius) {
                        Block block = loc.getBlock();
                        block.setType(blockType);
                    }
                }
            }
        }
    }
}