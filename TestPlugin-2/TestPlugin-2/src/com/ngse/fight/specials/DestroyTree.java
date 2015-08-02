package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.BlockTargettingAbility;

public class DestroyTree extends BlockTargettingAbility {

	public DestroyTree() {
		super("Destroy Tree", 10, "destre");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		// nothing
	}

	private void destroyTree(Block b) {
		if (b.getType().compareTo(Material.WOOD) == 12) {
			b.getWorld().createExplosion(b.getLocation(), 1);
			destroyTree(b.getLocation().add(0, 1, 0).getBlock());
		}
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.STICK, this);
	}

	@Override
	public boolean effect(Player p, Block b) {
		destroyTree(b);
		return true;
	}
}
