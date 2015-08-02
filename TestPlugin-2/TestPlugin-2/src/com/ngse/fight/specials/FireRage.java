package com.ngse.fight.specials;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Effects;

public class FireRage extends Ability {

	private static final int RADIUS = 10;

	// TODO needs work
	public FireRage() {
		super("Firerage", 25, "firrag");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		Location l = user.getLocation();
		for (int x = -RADIUS; x <= RADIUS; x++) {
			for (int y = -RADIUS; y <= RADIUS; y++)
				for (int z = -RADIUS; z <= RADIUS; z++) {
					Location l1 = l;
					l.add(x, y, z);
					if (l.getBlock().isEmpty()) {
						l.getBlock().setType(Material.FIRE);
						l.getBlock().getState().update();
					}
					Effects.sound(l1, Sound.FIRE_IGNITE);
				}
		}

	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.BLAZE_POWDER, this);
	}

}
