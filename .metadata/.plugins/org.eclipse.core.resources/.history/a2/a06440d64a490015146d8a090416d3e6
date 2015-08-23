package com.ngse.fight;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.classes.PassiveAbility;
import com.ngse.utilities.Effects;

public class PlayerDeathListener implements Listener {

	public void onPlayerDeath(PlayerDeathEvent evt) {
		Player p = evt.getEntity();

		p.sendMessage(p.getName() + " died");

		FightClass f = FightClass.get(p);

		if (f != null) {
			// end all passive effects
			for (Ability a : f.getAbilities()) {
				if (a instanceof PassiveAbility) {
					((PassiveAbility) a).endPassiveEffect(p);
				}
			}

			// remove fightclass meta
			p.removeMetadata("fightclass", FIGHT.plugin);

			// clear inventory
			p.getInventory().clear();

			// cool effect
			Effects.play(p.getLocation(), Effect.FLYING_GLYPH, 30);
		}
	}

}
