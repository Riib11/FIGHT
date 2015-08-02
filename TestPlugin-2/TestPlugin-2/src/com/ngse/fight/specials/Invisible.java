package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ngse.fight.classes.PassiveAbility;
import com.ngse.utilities.Toggle;

public class Invisible extends PassiveAbility {

	public Invisible() {
		super("Invisiblility", 1, "inv");
	}

	@Override
	public void passiveEffect(Player p) {
		// nothing
	}

	@Override
	public void endPassiveEffect(Player p) {
		p.removePotionEffect(PotionEffectType.INVISIBILITY);
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		togglePassiveAbility(user, this);
		if (Toggle.fromMeta(user, getName()).b) {
			user.addPotionEffect(new PotionEffect(
					PotionEffectType.INVISIBILITY, 10000000, 100, true, true));
		}
		user.playSound(user.getLocation(), Sound.PORTAL_TRAVEL, .3f, 1);

	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.BOWL, this);
	}

}
