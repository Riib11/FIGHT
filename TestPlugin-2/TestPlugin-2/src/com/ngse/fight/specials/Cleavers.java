package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ngse.fight.classes.Ability;

public class Cleavers extends Ability {

	private static final int EFFECTAMP = 3;
	private static final int EFFECTDUR = 60;

	public Cleavers() {
		super("Cleavers", 7, "cleav");
	}

	@Override
	public void effect(Player user, Player target) {
		target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
				EFFECTDUR, EFFECTAMP));
	}

	@Override
	public void effect(Player user) {

	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.SHEARS, this);
	}

}
