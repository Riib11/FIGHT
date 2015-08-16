package com.ngse.fight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bukkit.entity.Player;

import com.ngse.fight.classes.FightClass;
import com.ngse.fight.classes.PassiveAbility;
import com.ngse.utilities.Energy;

public class AL implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// Recharges energy
		for (Player p : FIGHT.plugin.getServer().getOnlinePlayers()) {
			FightClass f = FightClass.get(p);
			if (f != null) {
				// recharge mana
				if (Energy.get(p) >= FightClass.get(p).getmaxEnergy()) {
					Energy.set(p, FightClass.get(p).getmaxEnergy());
				} else {
					Energy.add(p, Finals.ENERGY_CHARGE * f.getRechargeSpeed());
				}

				// do passive abilities
				// PassiveAbility.activatePassiveAbilities(p);
			}
		}
	}
}
