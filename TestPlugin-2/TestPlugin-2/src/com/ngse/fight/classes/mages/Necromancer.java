package com.ngse.fight.classes.mages;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.specials.RaiseDead;

public class Necromancer extends FightClass {

	public Necromancer() {
		super("Necromancer", 40);
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ItemStack[] is = { new ItemStack(Material.APPLE), is(Material.APPLE) };
		return itemstacksArray(is);
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		Ability[] is = { new RaiseDead() };
		return abilitiesArray(is);
	}

}
