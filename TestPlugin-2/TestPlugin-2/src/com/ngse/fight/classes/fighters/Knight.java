package com.ngse.fight.classes.fighters;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;

public class Knight extends FightClass {

	public Knight(String name, int maxEnergy) {
		super(name, maxEnergy);

	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ItemStack[] i = { is(Material.APPLE), };
		return itemstacksArray(i);
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		Ability[] a = {};
		return abilitiesArray(a);
	}

}
