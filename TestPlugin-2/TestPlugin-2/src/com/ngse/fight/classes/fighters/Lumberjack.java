package com.ngse.fight.classes.fighters;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.specials.DestroyTree;

public class Lumberjack extends FightClass {

	public Lumberjack() {
		super("Lumberjack", 10);
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ItemStack[] i = {
				is(Material.APPLE),
				setupSpecialItem(Material.STONE_AXE, "Luberjax",
						"Ax of the mighty LumberJack", Enchantment.DAMAGE_ALL,
						20) };
		return itemstacksArray(i);
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		Ability[] a = { new DestroyTree()};
		return abilitiesArray(a);
	}

}
