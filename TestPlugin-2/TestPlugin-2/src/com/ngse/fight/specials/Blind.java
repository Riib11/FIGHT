package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ngse.fight.classes.Ability;

public class Blind extends Ability {

	public static final int DURATION = 40;
	public static final int AMPLIFY = 500;

	public Blind() {
		super("Blinding Strike", 10, "bli");
	}

	@Override
	public void effect(Player user, Player target) {
		target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
				DURATION, AMPLIFY));
	}

	@Override
	public void effect(Player user) {
		user.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
				DURATION, AMPLIFY));
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.NETHER_STAR, this);
	}
}
