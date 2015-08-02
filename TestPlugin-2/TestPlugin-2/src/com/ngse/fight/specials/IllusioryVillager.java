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

public class IllusioryVillager extends Ability {

	public static final int MAXHEIGHT = 2;

	public IllusioryVillager() {
		super("Illusion Villager", 15, "illvil");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		createVillager(user, null);
	}

	private NPC createVillager(Player p, Player target) {
		Location l = p.getLocation();
		Location t = p.getLocation().add(
				p.getLocation().getDirection().multiply(5));

		boolean safe = false;
		for (int x = 0; x <= MAXHEIGHT; x++) {
			t.add(0, x, 0);
			if (!t.getBlock().getType().isSolid()) {
				safe = true;
				break;
			}
		}

		NPC npc = null;

		if (safe) {
			p.teleport(t);

			npc = NPCLib.getNPCRegistry(FIGHT.plugin).createNPC(
					EntityType.PLAYER, p.getName());
			// npc.setSkin(p.getName());
			npc.spawn(l);
			npc.setProtected(false);
			((Player) npc.getEntity()).setMaxHealth(1);
			((Player) npc.getEntity()).setHealth(1);
		} else {
			// nothing
		}

		return npc;
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.CARROT_ITEM, this);
	}

}
