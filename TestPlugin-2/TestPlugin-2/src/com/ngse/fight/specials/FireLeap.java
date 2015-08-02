package com.ngse.fight.specials;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Effects;

public class FireLeap extends Ability {

	public static int AMP = 2;

	public FireLeap() {
		super("Fire Leap", 15, "firlea");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		Effects.play(user.getLocation(), Effect.FIREWORKS_SPARK, 10);
		Effects.play(user.getLocation(), Effect.EXPLOSION_HUGE, 1);
		Effects.play(user.getLocation(), Effect.FLAME, 10);
		Effects.sound(user.getLocation(), Sound.EXPLODE);
		user.setVelocity(user.getLocation().getDirection().multiply(AMP));
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.FIREWORK_CHARGE, this);
	}

}
