package com.ngse.fight.classes.mages;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.specials.FakeExplosions;
import com.ngse.fight.specials.IllusionZombies;
import com.ngse.fight.specials.IllusioryVillager;
import com.ngse.fight.specials.Invisible;
import com.ngse.fight.specials.ShadowClones;

public class Illusionist extends FightClass {

	public Illusionist() {
		super("Illusionist", 50);
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ItemStack[] i = { is(Material.BANNER) };
		return itemstacksArray(i);
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		Ability[] a = { new Invisible(), new IllusioryVillager(),
				new ShadowClones(), new IllusionZombies(), new FakeExplosions() };
		return abilitiesArray(a);
	}

}
