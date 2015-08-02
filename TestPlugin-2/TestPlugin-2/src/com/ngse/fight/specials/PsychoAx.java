package com.ngse.fight.specials;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Effects;

public class PsychoAx extends Ability {

	public PsychoAx() {
		super("Psychotic Ax", 2, "psyax");
	}

	private static final int EFFECTAMP = 3;
	private static final int EFFECTDUR = 100;

	@Override
	public void effect(Player user, Player target) {
		Effects.play(user.getLocation(), Effect.GHAST_SHRIEK, 1);
		target.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,
				EFFECTDUR, EFFECTAMP));
	}

	@Override
	public void effect(Player user) {
		Effects.play(user.getLocation(), Effect.GHAST_SHRIEK, 1);
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.STONE_AXE, this);
	}

}
