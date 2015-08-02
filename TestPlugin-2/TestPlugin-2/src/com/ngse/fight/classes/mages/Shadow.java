package com.ngse.fight.classes.mages;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.specials.BackstabDagger;
import com.ngse.fight.specials.Blind;
import com.ngse.fight.specials.DarkLeap;
import com.ngse.fight.specials.Invisible;
import com.ngse.fight.specials.TeleportBackward;

public class Shadow extends FightClass {

	public Shadow() {
		super("Shadow", 40);
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		Ability[] a = { new TeleportBackward(), new Invisible(), new Blind(),
				new DarkLeap(), new BackstabDagger() };
		return abilitiesArray(a);
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ItemStack[] i = { is(Material.DIAMOND_SWORD),
				is(Material.LEATHER_BOOTS), is(Material.LEATHER_CHESTPLATE),
				is(Material.LEATHER_HELMET), is(Material.LEATHER_LEGGINGS) };
		return itemstacksArray(i);
	}
}
