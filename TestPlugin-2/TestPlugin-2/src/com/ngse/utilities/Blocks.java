package com.ngse.utilities;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class Blocks {

	public static List<Block> getNearbyBlocks(Location location, int radius) {
		List<Block> blocks = new ArrayList<Block>();
		for (int x = location.getBlockX() - radius; x <= location.getBlockX()
				+ radius; x++) {
			for (int y = location.getBlockY() - radius; y <= location
					.getBlockY() + radius; y++) {
				for (int z = location.getBlockZ() - radius; z <= location
						.getBlockZ() + radius; z++) {
					blocks.add(location.getWorld().getBlockAt(x, y, z));
				}
			}
		}
		return blocks;
	}

}
