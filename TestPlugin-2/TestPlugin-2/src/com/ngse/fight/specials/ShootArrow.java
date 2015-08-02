package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;

public class ShootArrow extends Ability {

	public ShootArrow() {
		super("Arrow Shot", 5, "arrsho");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		user.launchProjectile(Arrow.class);
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.ARROW, this);
	}

}
