package com.ngse.fight.specials;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ngse.fight.classes.PassiveAbility;

public class FireForm extends PassiveAbility {

	public FireForm() {
		super("FireForm", 0, "firfor");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		togglePassiveAbility(user, this);
		if (this.isActive(user)) {
			user.addPotionEffect(new PotionEffect(
					PotionEffectType.FIRE_RESISTANCE, 100000, 100));
			user.addPotionEffect(new PotionEffect(
					PotionEffectType.INVISIBILITY, 100000, 1));
			user.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
					100000, 1));
		}
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.FLINT, this);
	}

	@Override
	public void passiveEffect(Player p) {
		Location l = p.getLocation().add(0, 1, 0);
		p.getWorld().spigot()
				.playEffect(l, Effect.FLAME, 1, 1, 0, 0, 0, .05f, 20, 4);
		p.setFireTicks(100);
	}

	@Override
	public void endPassiveEffect(Player p) {
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.INVISIBILITY);
	}

}
