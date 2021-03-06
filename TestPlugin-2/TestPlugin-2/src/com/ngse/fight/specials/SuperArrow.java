package com.ngse.fight.specials;

import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.PassiveAbility;
import com.ngse.utilities.Toggle;

public class SuperArrow extends PassiveAbility {

	public SuperArrow() {
		super("Super Arrows", 0, "suparr");
	}

	public static final String metadataKey = "superarrow";

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		if (user.hasMetadata(metadataKey)) {
			Toggle.toggleMeta(user, metadataKey);
		} else {
			Toggle.setMetaToggle(user, metadataKey, true);
		}
		user.sendMessage("Super Arrow: " + Toggle.fromMeta(user, metadataKey).b);
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.FIREWORK_CHARGE, this);
	}

	@Override
	public void passiveEffect(Player p) {

	}

	@Override
	public void endPassiveEffect(Player p) {

	}

	public static void arrowHit(Projectile projectile) {
		Location l = projectile.getLocation();
		Collection<Entity> entities = projectile.getNearbyEntities(5, 5, 5);
		for (Entity e : entities) {
			e.getWorld().createExplosion(e.getLocation(), 3f);
		}
		l.getWorld().createExplosion(l, 3f);
	}
}
