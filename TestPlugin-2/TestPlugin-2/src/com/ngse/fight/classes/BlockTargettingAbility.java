package com.ngse.fight.classes;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public abstract class BlockTargettingAbility extends Ability {

	public BlockTargettingAbility(String name, int level, String MID) {
		super(name, level, MID);
	}

	public abstract boolean effect(Player p, Block b);

}
