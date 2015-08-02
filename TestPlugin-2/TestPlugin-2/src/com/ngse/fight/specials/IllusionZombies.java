package com.ngse.fight.specials;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ngse.fight.classes.Ability;

public class IllusionZombies extends Ability {

	public IllusionZombies() {
		super("Zomlusions", 20, "zomlus");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		List<Entity> entities = user.getNearbyEntities(10, 10, 10);
		Location t = user.getLocation().add(
				user.getLocation().getDirection().multiply(3));
		if (t.getBlock().isEmpty()) {
			Zombie z = (Zombie) user.getWorld().spawn(t, Zombie.class);
			z.setMaxHealth(3);
			z.setHealth(3);
			z.addPotionEffect(new PotionEffect(
					PotionEffectType.FIRE_RESISTANCE, 100000, 100000));

			// set target to a nearby player
			for (Entity e : entities) {
				if (e instanceof Player && !e.equals(user)) {
					z.setTarget((LivingEntity) e);
					break;
				}
			}
		}
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.ROTTEN_FLESH, this);
	}

}
