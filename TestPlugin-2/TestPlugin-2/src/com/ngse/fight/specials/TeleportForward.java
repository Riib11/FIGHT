package com.ngse.fight.specials;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Direction;
import com.ngse.utilities.Effects;

public class TeleportForward extends Ability {

	private static final int MAXHEIGHT = 2;
	private static final int RANGE = 3;

	public TeleportForward() {
		super("Teleboost Wand", 10, "telboo");
	}

	@Override
	public void effect(Player user, Player target) {
		// teleport right behind the target
		puff(user);
		Location tloc = target.getLocation();
		tloc = tloc.add(Direction.getOppDir(target));
		if (tloc.getBlock().isEmpty()) {
			user.teleport(tloc);
		}
		puff(user);

	}

	@Override
	public void effect(Player user) {
		// teleport in the direction you are facing by RANGE blocks
		Location loc = user.getLocation();
		loc.add(loc.getDirection().multiply(RANGE));

		// check where you are trying to go. If its not air, then will add 1 to
		// y and try again. If not good MaxHeigh blocks above, then fails
		boolean safe = false;
		for (int x = 0; x <= MAXHEIGHT; x++) {
			loc.add(0, x, 0);
			if (!loc.getBlock().getType().isSolid()) {
				safe = true;
				break;
			}
		}
		if (safe) {
			Hover.destroyHoveringBlock(user, true);
			puff(user);
			user.teleport(loc);

			puff(user);
		}

	}

	private void puff(Player p) {
		Effects.sound(p.getLocation(), Sound.ENDERMAN_TELEPORT);
		Effects.play(p.getLocation().add(0, 1, 0), Effect.EXPLOSION_LARGE, 2);
	}

	@Override
	public ItemStack getItem() {
		return Ability.setupItem(Material.ARROW, this);
	}

}
