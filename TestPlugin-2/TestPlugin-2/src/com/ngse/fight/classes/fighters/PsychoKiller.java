package com.ngse.fight.classes.fighters;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.classes.Mage;
import com.ngse.fight.specials.Cleavers;
import com.ngse.fight.specials.PassiveSpeediness;
import com.ngse.fight.specials.PsychoAx;

public class PsychoKiller extends FightClass implements Mage {

	public PsychoKiller() {
		super("Psycho_Killer", 10);
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ItemStack[] i = { new ItemStack(Material.FERMENTED_SPIDER_EYE),
				new ItemStack(Material.ROTTEN_FLESH), };
		return itemstacksArray(i);
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		Ability[] a = { new PsychoAx(), new Cleavers(), new PassiveSpeediness() };
		return abilitiesArray(a);
	}

}
