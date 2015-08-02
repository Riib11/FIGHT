package com.ngse.fight.specials;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Effects;

public class FakeExplosions extends Ability {

	public FakeExplosions() {
		super("\"Explostions\"", 20, "fakexp");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		for (int x = -1; x <= 1; x++) {
			for (int z = -1; z <= 1; z++) {
				Effects.play(user.getLocation().add(x, 1, z),
						Effect.EXPLOSION_HUGE, 10);
			}
		}
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.SULPHUR, this);
	}

}
