package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Effects;

public class HighJump extends Ability {

	private static double AMP = 1.1;

	public HighJump() {
		super("High Jump", 10, "higjum");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		Vector v = user.getLocation().getDirection().setY(AMP);
		user.setVelocity(v);
		Effects.sound(user.getLocation(), Sound.ENDERMAN_TELEPORT);
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.FEATHER, this);
	}

}
