package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Effects;

public class SetFire extends Ability {

	public SetFire() {
		super("Ignite", 15, "ign");
	}

	@Override
	public void effect(Player user, Player target) {
		target.setFireTicks(100);
		Effects.sound(target.getLocation(), Sound.BLAZE_HIT);
	}

	@Override
	public void effect(Player user) {
		// nothing
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.FLINT, this);
	}

}
