package com.ngse.fight;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.ngse.fight.classes.FightClass;

public class PlayerAttackPlayerListener implements Listener {

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			Player user = (Player) e.getDamager();
			Player target = (Player) e.getEntity();
			if (user.hasMetadata("fightclass")) {
				FightClass f = (FightClass) FightClass.get(user);
				if (f != null) {
					f.useAbility(user, target);
				}
			} else {
				// dont do anything
			}
		}

	}

}
