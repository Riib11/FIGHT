package com.ngse.fight;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import com.ngse.fight.specials.SuperArrow;
import com.ngse.utilities.Toggle;

public class ProjectileHitListener implements Listener {

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		Projectile projectile = e.getEntity();
		FIGHT.log(projectile.getShooter().toString());

		if (projectile.getShooter() instanceof Player) {
			Player p = ((Player) projectile.getShooter());
			p.sendMessage("Hitting projectile, super_arrow:"
					+ Toggle.fromMeta(p, SuperArrow.metadataKey).b);
			if (Toggle.fromMeta(p, SuperArrow.metadataKey).b) {
				((Player) projectile.getShooter())
						.sendMessage("Shooting super arrow");
				SuperArrow.arrowHit(projectile);
			}
		}
	}
}
