package com.ngse.fight.classes.mages;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.specials.FireForm;
import com.ngse.fight.specials.FireLeap;
import com.ngse.fight.specials.FireRage;
import com.ngse.fight.specials.SetFire;
import com.ngse.fight.specials.ShootFireball;

public class Pyromancer extends FightClass {

	public Pyromancer() {
		super("Pyromancer", 40);
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ItemStack[] i = {
				new ItemStack(Material.BLAZE_POWDER),
				setupSpecialItem(Material.STONE_SWORD, "Sword of Flames",
						"Use this sword to burn everyone",
						Enchantment.FIRE_ASPECT, 3),
				setupSpecialItem(Material.LEATHER_BOOTS, "Landing Boots", "",
						Enchantment.PROTECTION_FALL, 100) };
		return itemstacksArray(i);
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		Ability[] a = { new ShootFireball(), new FireLeap(), new FireForm(),
				new SetFire(), new FireRage() };
		return abilitiesArray(a);
	}

}
