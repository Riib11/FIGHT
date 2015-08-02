package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ngse.fight.classes.PassiveAbility;
import com.ngse.utilities.Effects;
import com.ngse.utilities.Toggle;

public class PassiveSpeediness extends PassiveAbility {

	private static final int EFFECTAMP = 5;

	public PassiveSpeediness() {
		super("Speediness", 0, "spedi");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		Toggle.toggleMeta(user, getName());
	}

	@Override
	public void passiveEffect(Player p) {
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100,
				EFFECTAMP));
		Effects.sound(p.getLocation(), Sound.WOLF_WALK);
	}

	@Override
	public void endPassiveEffect(Player p) {
		p.removePotionEffect(PotionEffectType.SPEED);
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.REDSTONE, this);
	}

}
