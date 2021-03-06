package com.ngse.fight.specials;

import java.util.Collection;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.BlockTargettingAbility;
import com.ngse.utilities.Effects;

public class RaiseDead extends BlockTargettingAbility {

	private static int NUM = 30;

	public RaiseDead() {
		super("Raise Dead", 20, "raidea");
	}

	@Override
	public boolean effect(Player p, Block b) {
		Location loc = b.getLocation().add(0, 1, 0);

		if (!loc.getBlock().isEmpty()) {
			return false;
		}

		for (int x = -1; x <= 1; x++) {
			for (int z = -1; z <= 1; z++) {
				Location l = loc;
				Effects.play(l.add(x, 0, z), Effect.TILE_BREAK, NUM);
			}
		}
		Zombie z = p.getWorld().spawn(loc, Zombie.class);

		for (Entity e : p.getNearbyEntities(20, 20, 20)) {
			if (e instanceof Player && !e.equals(p)) {
				z.setTarget((Player) e);
				break;
			}
		}

		return true;
	}

	@Override
	public void effect(Player user, Player target) {
		// nothing
	}

	@Override
	public void effect(Player user) {
		// nothing

	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.STICK, this);
	}

}
