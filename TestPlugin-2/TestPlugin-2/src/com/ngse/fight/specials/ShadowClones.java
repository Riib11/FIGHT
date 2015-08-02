package com.ngse.fight.specials;

import net.techcable.npclib.NPC;
import net.techcable.npclib.NPCLib;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.FIGHT;
import com.ngse.fight.classes.Ability;

public class ShadowClones extends Ability {

	public static final int MAXHEIGHT = 3;

	public ShadowClones() {
		super("Shadow Clones", 20, "shaclo");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		Location t = user.getLocation().add(
				user.getLocation().getDirection().multiply(5));
		boolean safe = false;
		for (int x = 0; x <= MAXHEIGHT; x++) {
			t.add(0, x, 0);
			if (!t.getBlock().getType().isSolid()) {
				safe = true;
				break;
			}
		}
		if (safe) {
			createVillager(user, user.getLocation());
			user.teleport(t);
		}
	}

	private NPC createVillager(Player p, Location l) {
		NPC npc = null;
		npc = NPCLib.getNPCRegistry(FIGHT.plugin).createNPC(EntityType.PLAYER,
				p.getName());
		// npc.setSkin(p.getName());
		((Player) npc.getEntity()).setMaxHealth(1);
		((Player) npc.getEntity()).setHealth(1);
		for (int x = -1; x <= 1; x++) {
			for (int z = -1; z <= 1; z++) {
				Location loc = l;
				npc.spawn(loc.add(x, 0, z));
				npc.setProtected(false);
			}
		}

		return npc;
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.FIREWORK_CHARGE, this);
	}

}
