package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Effects;

public class ShootFireball extends Ability {

	public ShootFireball() {
		super("Fireball", 15, "firbal");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		user.launchProjectile(Fireball.class);
		Effects.sound(user.getLocation(), Sound.BLAZE_HIT);
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.BLAZE_ROD, this);
	}

}
