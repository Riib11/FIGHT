package com.ngse.fight.classes.fighters;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.specials.HighJump;
import com.ngse.fight.specials.Invisible;
import com.ngse.fight.specials.PassiveSpeediness;
import com.ngse.fight.specials.ShootArrow;
import com.ngse.fight.specials.TeleportBackward;

public class Ninja extends FightClass {

	public Ninja() {
		super("Ninja", 15);
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ItemStack[] i = { is(Material.STONE_SWORD),
				is(Material.LEATHER_CHESTPLATE), setupSpecialItem(Material.LEATHER_BOOTS, "Ninjaboots", "",
						Enchantment.PROTECTION_FALL, 100)  };
		return itemstacksArray(i);
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		Ability[] a = { new ShootArrow(), new Invisible(),
				new TeleportBackward(), new HighJump(), new PassiveSpeediness() };
		return abilitiesArray(a);
	}

}
