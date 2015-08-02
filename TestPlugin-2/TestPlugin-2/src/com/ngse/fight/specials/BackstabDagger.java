package com.ngse.fight.specials;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Effects;

public class BackstabDagger extends Ability {

	public BackstabDagger() {
		super("Death from Behind", 20, "deafrobeh");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Player user, Player target) {
		Location pl = user.getLocation();
		Location tl = target.getLocation();
		double angle = Math.abs(Math.acos(pl.getDirection().dot(
				tl.getDirection())));
		if (angle >= 100) {
			target.setHealth(2);
			specialEffects(target);
		} else {
			// nothing
		}
	}

	@Override
	public void effect(Player user) {
		// nothing
		specialEffects(user);
	}

	private void specialEffects(Player user) {
		Effects.play(user.getLocation().add(0, 1, 0), Effect.CRIT, 50);
		Effects.sound(user.getLocation(), Sound.SUCCESSFUL_HIT);
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.GOLD_SWORD, this);
	}

}
